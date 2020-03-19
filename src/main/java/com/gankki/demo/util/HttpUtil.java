package com.gankki.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;


public class HttpUtil {

	protected static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param params
	 *            请求参数
	 * @param connectTimeout
	 *            连接超时时间（毫秒）
	 * @param readTimeout
	 *            读取超时时间（毫秒）
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, Map<String, Object> params,int connectTimeout,int readTimeout) throws RuntimeException{
		String result = "";
		BufferedReader in = null;
		try {
			/** 组装参数 **/
			String param = parseParams(params);
			String urlNameString = url +(StringUtils.isEmpty(param)?"": "?" + param);
			URL realUrl = new URL(urlNameString);
			/** 打开和URL之间的连接 **/
			URLConnection connection = realUrl.openConnection();
			/** 设置通用的请求属性 **/
			connection.setConnectTimeout(connectTimeout);
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			/** 建立实际的连接 **/
			connection.connect();
			/** 定义 BufferedReader输入流来读取URL的响应 **/
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送GET请求出现异常！", e);
			throw new RuntimeException("发送GET请求出现异常！",e);
		} finally {/** 使用finally块来关闭输入流 **/
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception ex) {
				logger.error("http get",ex);
				throw new RuntimeException("发送GET请求出现异常！",ex);
			}
		}
		return result;
	}


	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param params
	 *            请求参数
	 * @param connectTimeout
	 *            连接超时时间（毫秒）
	 * @param readTimeout
	 *            读取超时时间（毫秒）
	 * @return 所代表远程资源的响应结果
	 */
	
	public static String sendPost(String url, Map<String, Object> params,int connectTimeout,int readTimeout)throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			/** 打开和URL之间的连接 **/
			URLConnection conn = realUrl.openConnection();
			/** 设置通用的请求属性 **/
			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			/** 发送POST请求必须设置如下两行 **/
			conn.setDoOutput(true);
			conn.setDoInput(true);
			/** 获取URLConnection对象对应的输出流 **/
			out = new PrintWriter(conn.getOutputStream());
			/** 发送请求参数 **/
			String param = parseParams(params);
			out.print(param);
			/** flush输出流的缓冲 **/
			out.flush();
			/** 定义BufferedReader输入流来读取URL的响应 **/
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送 POST 请求出现异常！" , e);
			throw new RuntimeException("发送 POST 请求出现异常！",e);
		} finally { /** 使用finally块来关闭输出流、输入流 **/
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				logger.error("http post IOException",ex);
				throw new RuntimeException("http post IOException",ex);
			}
		}
		return result;
	}

	/**
	 * 将HashMap参数组装成字符串
	 * 
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static String parseParams(Map<String, Object> map) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		if (map != null && map.keySet().size() > 0) {
			for (Entry<String, Object> e : map.entrySet()) {
				sb.append(e.getKey());
				sb.append("=");
				if(e.getValue()==null|| StringUtils.isEmpty(e.getValue().toString()) || "null".equals(e.getValue())){
					sb.append("");
				}else{
					sb.append(URLEncoder.encode(e.getValue().toString(), "UTF-8"));
				}
				sb.append("&");
			}
			return sb.substring(0, sb.length() - 1);
		}
		return sb.toString();
	}
	
	public static String post(String url, Map param){
		return HttpsUtil.post(url, JSON.toJSONString(param));
	}
	
	public static String post(String url, String param){
		return HttpsUtil.post(url, param);
	}
	
	/**
	 * 向指定 URL 发送POST方法的请求并将参数编辑为json
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数
	 * @param connectTimeout
	 *            连接超时时间（毫秒）
	 * @param readTimeout
	 *            读取超时时间（毫秒）
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendJsonPost(String url, Map<String, Object> params,int connectTimeout,int readTimeout)throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			/** 打开和URL之间的连接 **/
			URLConnection conn = realUrl.openConnection();
			/** 设置通用的请求属性 **/
			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/json");
			/** 发送POST请求必须设置如下两行 **/
			conn.setDoOutput(true);
			conn.setDoInput(true);
			/** 获取URLConnection对象对应的输出流 **/
			out = new PrintWriter(conn.getOutputStream());
			/** 发送请求参数 **/
			String param = parseParams(params);
			out.print(JSONObject.toJSONString(params));
			/** flush输出流的缓冲 **/
			out.flush();
			/** 定义BufferedReader输入流来读取URL的响应 **/
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			logger.error("发送 POST 请求出现异常！" , e);
			throw new RuntimeException("发送 POST 请求出现异常！",e);
		} finally { /** 使用finally块来关闭输出流、输入流 **/
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				logger.error("http post IOException",ex);
				throw new RuntimeException("http post IOException",ex);
			}
		}
		return result;
	}
	
	  //post请求参数为json格式
    public static String HttpPostWithJson(String url, String json) {
        String returnValue = "这是默认返回值，接口调用失败";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try{
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();
 
            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);
 
            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json,"utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);
 
            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPost,responseHandler); //调接口获取返回值时，必须用此方法
 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
 
        finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //第五步：处理返回值
        return returnValue;
    }

	public static String get(String url) {
		HttpURLConnection connection = null;
		try {
			URL realUrl = new URL(url);
			connection = (HttpURLConnection) realUrl.openConnection();
			connection.setDoOutput(true);
			connection.connect();
			InputStream inputStream = connection.getInputStream();
			return StreamUtils.copyToString(inputStream, Charsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != connection) {
				connection.disconnect();
			}
		}
		return null;
	}

}
