package com.gankki.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MD5Encryption {

	private static Logger logger = LoggerFactory.getLogger(MD5Encryption.class);

	private MD5Encryption() {

	}

	public static String getEncryption(String originString) {
		String result = "";
		if (originString != null) {
			try {
				// 指定加密的方式为MD5
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 进行加密运算
				byte bytes[] = md.digest(originString.getBytes());
				for (int i = 0; i < bytes.length; i++) {
					// 将整数转换成十六进制形式的字符串 这里与0xff进行与运算的原因是保证转换结果为32位
					String str = Integer.toHexString(bytes[i] & 0xFF);
					if (str.length() == 1) {
						str += "F";
					}
					result += str;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public final static String MD5(String data) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            byte[] btInput = data.getBytes("UTF-8");
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}


	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}
	
	private static String sortData(TreeMap<String, Object> data) {
	    Set<Entry<String,Object>> entrySet = data.entrySet();
	    StringBuilder sb = new StringBuilder();
	    for (Entry<String, Object> e : entrySet) {
	      String key = (String)e.getKey();
	      String value = e.getValue().toString();
	      if (value == null) {
	      	continue;
	      }
	      if (value.length() == 0) {
	        continue;
	      }
	      sb.append("&").append(key).append("=").append(value);
	    }
	    if(sb.length() > 0){
	    	sb.deleteCharAt(0);
	    }
	    String sortData = sb.toString();
	    return sortData;
	 }
	
	public static  String sign(TreeMap<String,Object> param){
		return MD5(sortData(param));
	}



}
