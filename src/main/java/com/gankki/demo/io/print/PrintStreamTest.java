package com.gankki.demo.io.print;

import java.io.IOException;
import java.io.PrintStream;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/25
 */
public class PrintStreamTest {
	
	
	public static void main(String[] args) throws IOException {
		PrintStream ps = new PrintStream("E:/gankkscode/gankkidir/hello9.txt");
		ps.println(1);
		ps.println("haha");
		ps.println("我们");
		ps.println(1214.44f);
		ps.println(1111111111111111L);
	}
}
