package com.gankki.demo.io.bytearray;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class ByteArrayInputStreamTest {

	/**
	 * ByteArrayInputStream将byte数组包装为一个输入流，是一种适配器模式
	 * ByteArrayInputStream的所有数据都在内存，支持mark/reset重复读取。
	 *
	 * 为什么要将byte数组转换为InputStream呢？这与容器类中要将数组、单个元素转换为容器接口的原因是类似的，
	 * 有很多代码是以InputStream/OutputSteam为参数构建的，它们构成了一个协作体系，
	 * 将byte数组转换为InputStream可以方便的参与这种体系，复用代码。
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);

		while( bOutput.size()!= 10 ) {
			// 获取用户输入值
			bOutput.write(System.in.read());
		}

		byte b [] = bOutput.toByteArray();
		System.out.println("Print the content");
		for(int x= 0 ; x < b.length; x++) {
			// 打印字符
			System.out.print((char)b[x]  + " ");
		}
		System.out.println("   ");

		int c;

		ByteArrayInputStream bInput = new ByteArrayInputStream(b);

		System.out.println("Converting characters to Upper case " );
		for(int y = 0 ; y < 1; y++ ) {
			while(( c= bInput.read())!= -1) {
				System.out.println(Character.toUpperCase((char)c));
			}
			bInput.reset();
		}
	}
}
