package com.gankki.demo.io.chararray;

import java.io.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class CharArrayWriterTest {

	public static void main(String[] args) throws IOException {
		Reader reader = new InputStreamReader(
				new FileInputStream("hello.txt"), "GB2312");
		try{
			CharArrayWriter writer = new CharArrayWriter();
			char[] cbuf = new char[1024];
			int charsRead = 0;
			while((charsRead=reader.read(cbuf))!=-1){
				writer.write(cbuf, 0, charsRead);
			}
			System.out.println(writer.toString());
		}finally{
			reader.close();
		}
	}
}
