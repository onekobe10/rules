package com.gankki.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.TreeMap;
import java.util.UUID;

/**
 * https请求工具类
 *
 * cuilong
 * 2019年8月29日 上午10:41:44
 * 
 * @version 1.0.0
 *
 */
@Slf4j
public class HttpsUtil {
	
	private SSLSocketFactory _sslSocketFactory = null;
	private NullHostNameVerifier _hostNameVerifier = null;
	private static HttpsUtil instance = new HttpsUtil(); 
	//构造函数
	private HttpsUtil() {
		try {
			_hostNameVerifier = new NullHostNameVerifier();
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new X509TrustManager[]{new NullX509TrustManager()}, new SecureRandom());
			
			_sslSocketFactory = context.getSocketFactory();
		} catch (Exception e) {
		}
	}
	/**
	 * 发送报文，返回结果，返回""代表异常或请求失败，查看log
	 * @param url
	 * @param
	 * @param
	 * @return
	 */
	public static String post(String url, String postData)
    {
		HttpsURLConnection conn = null;
		DataOutputStream dos = null;
		BufferedReader br = null;
		try 
		{
			byte[] data = postData.getBytes("UTF-8");
			trustAllHosts();
			//创建一个HttpsURLConnection连接		
			conn=(HttpsURLConnection) (new URL(url)).openConnection();
			//设置连接超时时间
			conn.setConnectTimeout(8000);
			//post请求必须设置允许输出
			conn.setDoOutput(true);				
			//post请求不能使用缓存
			conn.setUseCaches(false);
			//设置post方式请求
			conn.setRequestMethod("POST");
			conn.setInstanceFollowRedirects(true); 
			// 配置请求Content-Type
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			//开始连接,注意以上的所有设置必须要在connect之前完成		
			conn.connect();
			// 发送请求参数,将OutputStream封装成DataOutputStream				
			dos = new DataOutputStream(conn.getOutputStream());				
			dos.write(data);
			dos.flush();
            
			//请求成功
			int returnCode = conn.getResponseCode();
			if(returnCode == 200) 
			{	
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				StringBuffer strBuf = new StringBuffer();
				String line = null;
				while(true)
				{
					line = br.readLine();
					if (line == null) {
						return strBuf.toString();
					}
					strBuf.append(line);						
				}
			} 
			else {
				System.out.println("HttpsUtil.post,Http return code: " + returnCode + ", postData: " + postData);
			}
		}
		catch (Exception e) {
//			e.printStackTrace();
			throw  new RuntimeException(e);
		}
		finally {
			if (br != null) {
				try { br.close(); } catch(Exception e) {}
			}
			if (dos != null) {
				try { dos.close(); } catch(Exception e) {}
			}
			if (conn != null) {
				try {conn.disconnect();	} catch (Exception e) {}
			}
		}
		
		return null;
    }

	public static JSONObject postUrl(String url, TreeMap<String, String> param)
	{
		String postParam = processParam(param);
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try
		{
			String sendUrl = String.format("%s?%s", url, postParam);
			log.info(sendUrl);
			URL url1 = new URL(sendUrl);
			if(url1.getProtocol()!=null && url1.getProtocol().equals("https")){
				trustAllHosts();
			}
			conn=(HttpURLConnection) (url1).openConnection();
			conn.setConnectTimeout(8000);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.connect();
			int returnCode = conn.getResponseCode();
			if(returnCode == 200)
			{
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				StringBuffer strBuf = new StringBuffer();
				String line = null;
				while(true)
				{
					line = br.readLine();
					if (line == null) {
						return JSON.parseObject(strBuf.toString());
					}
					strBuf.append(line);
				}
			}
			else {
				System.out.println("HttpsUtil.post,Http return code: " + returnCode + ", postData: " + param);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (br != null) {
				try { br.close(); } catch(Exception e) {}
			}
			if (conn != null) {
				try {conn.disconnect();	} catch (Exception e) {}
			}
		}

		return null;
	}

	/**
	 * 调用金牛api拼接参数工具
	 * @param param
	 * @return
	 */
	public static String processParam(TreeMap<String, String> param) {

		param.put("orderNumber", UUID.randomUUID().toString().replaceAll("-", ""));
//		MD5Encryption md5 = new MD5Encryption();
		String sign = MD5Encryption.sign(new TreeMap<>(param));
		param.put("sign", sign);
		String postParam = "";
		for(String key:param.keySet()){
			try {
				postParam+=key+"="+ URLEncoder.encode(param.get(key), "UTF-8")+"&";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return postParam;
	}
	
	/*
	 * 信任所有主机
	 */
	private static void trustAllHosts() 
	{
		HttpsURLConnection.setDefaultHostnameVerifier(instance._hostNameVerifier);
		HttpsURLConnection.setDefaultSSLSocketFactory(instance._sslSocketFactory);		
	}
	
}

class NullHostNameVerifier implements HostnameVerifier
{
	public boolean verify(String hostname, SSLSession session) 
	{  
        return true;
    }
}

class NullX509TrustManager implements X509TrustManager
{
    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)  throws CertificateException {  }
    
    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)  throws CertificateException {   }
    
    public java.security.cert.X509Certificate[] getAcceptedIssuers() 
    {
    	return null;
    }
}
