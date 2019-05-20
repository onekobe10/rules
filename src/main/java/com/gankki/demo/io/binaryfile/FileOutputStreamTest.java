package com.gankki.demo.io.binaryfile;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/20
 */
public class FileOutputStreamTest {
	
	
	public static void main(String[] args) throws Exception{
		// 如果文件不存在会自动创建
		OutputStream output =  new FileOutputStream("E:/gankkscode/gankkidir/hello.txt");
		try{
			String data = "hello, 123, 老马";
			byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
			output.write(bytes);
		}finally{
			output.close();
		}
	}
}
