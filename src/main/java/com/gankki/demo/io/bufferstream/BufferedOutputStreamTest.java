package com.gankki.demo.io.bufferstream;

import java.io.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class BufferedOutputStreamTest {

	/**
	 * 缓冲区的大小为8192
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		InputStream input = new BufferedInputStream(new FileInputStream("hello.txt"));
		OutputStream output =  new BufferedOutputStream(new FileOutputStream("hello.txt"));

		DataInputStream input1 = new DataInputStream(
				new BufferedInputStream(new FileInputStream("students.dat")));
		DataOutputStream output1 = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("students.dat")));
	}


}
