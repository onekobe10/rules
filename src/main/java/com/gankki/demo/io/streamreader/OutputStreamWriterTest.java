package com.gankki.demo.io.streamreader;

import java.io.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class OutputStreamWriterTest {


	public static void main(String[] args) throws IOException {
		String path = "E:/gankkscode/gankkidir/hello2.txt";
		Writer writer = new OutputStreamWriter(
				new FileOutputStream(path), "GB2312");
		try{
			String str = "hello, 123, 老马";
			writer.write(str);
		}finally{
			writer.close();
		}

		/**
		 * 这段代码假定一次read调用就读到了所有内容，且假定长度不超过1024。
		 */
		Reader reader = new InputStreamReader(
				new FileInputStream(path), "GB2312");
		try{
			char[] cbuf = new char[1024];
			int charsRead = reader.read(cbuf);
			System.out.println(new String(cbuf, 0, charsRead));
		}finally{
			reader.close();
		}
	}
}
