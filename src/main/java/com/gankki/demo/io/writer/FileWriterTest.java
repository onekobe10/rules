package com.gankki.demo.io.writer;

import java.io.FileWriter;
import java.io.Writer;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/25
 */
public class FileWriterTest {


	public static void main(String[] args) throws Exception {
		Writer writer = new FileWriter("E:/gankkscode/gankkidir/hello10.txt");
		writer.write("你好");
		writer.write("\n");
		writer.write(new String("你好".getBytes("GBK"), "GBK"));
		writer.flush();
		writer.close();
		System.out.println("1");
	}
}
