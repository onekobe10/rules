package com.gankki.demo.optimization.java.o3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/20
 */
public class Test {


	public static void main(String[] args){
		String str1= "abc";
		String str2= new String("abc");
		String str3= str2.intern();

		// false
		System.out.println(str1==str2);
		// false
		System.out.println(str2==str3);
		// true
		System.out.println(str1==str3);

		// intern 优化内存
		String a = new String("abc").intern();
		String b = new String("abc").intern();
		if (a == b ) {
			System.out.print("a==b");
		}


	}

}
