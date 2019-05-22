package com.gankki.demo.io.bytearray;

import java.io.*;

/**
 *@desc	以字节为单位读写
 *@author liuhao
 *@createDate 2019/5/22
 */
public class ByteArrayOutputStreamTest {


	/**
	 * ByteArrayOutputStream 如果没有指定，默认长度为32。
	 * 在调用write方法的过程中，如果数组大小不够，会进行扩展，扩展策略同样是指数扩展，每次至少增加一倍。
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream input = new FileInputStream("E:/gankkscode/gankkidir/hello.txt");
		try{
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int bytesRead = 0;
			while((bytesRead=input.read(buf))!=-1){
				output.write(buf, 0, bytesRead);
			}
			String data = output.toString("UTF-8");
			System.out.println(data);

		}finally{
			input.close();
		}
	}
}
