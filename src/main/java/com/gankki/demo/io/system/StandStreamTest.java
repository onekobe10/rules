package com.gankki.demo.io.system;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class StandStreamTest {

	/**
	 * System.out向屏幕上输出，它是一个PrintStream对象，输出目标就是所谓的"标准"输出，经常是屏幕。
	 *
	 * System.in表示标准输入，它是一个InputStream对象，输入源经常是键盘。
	 *
	 * System.err表示标准错误流，一般异常和错误信息输出到这个流，它也是一个PrintStream对象，输出目标默认与System.out一样，一般也是屏幕。
	 *
	 * 标准流的一个重要特点是，它们可以重定向，比如可以重定向到文件，从文件中接受输入，输出也写到文件中。
	 * 在Java中，可以使用System类的setIn, setOut, setErr进行重定向，比如：
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		/**
		 * 从键盘读入
		 */
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(num);

		/**
		 * 标准输入重定向到了一个ByteArrayInputStream，
		 * 标准输出和错误重定向到了文件，所以第一次调用in.nextLine就会读取到"hello"，
		 * 输出文件out.txt中也包含该字符串，第二次调用in.nextLine会触发异常，
		 * 异常消息会写到错误流中，即文件err.txt中会包含异常消息，为"No line found"。
		 */
		System.setIn(new ByteArrayInputStream("hello".getBytes("UTF-8")));
		System.setOut(new PrintStream("out.txt"));
		System.setErr(new PrintStream("err.txt"));

		try{
			Scanner in1 = new Scanner(System.in);
			System.out.println(in1.nextLine());
			System.out.println(in1.nextLine());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}
