package com.gankki.demo.ma;

public class EncodeTest {
	
	public static void main(String[] args) throws Exception{
		String str = "ÀÏÂí";
		String newStr = new String(str.getBytes("windows-1252"),"GB18030");
		System.out.println(newStr);

		System.out.println(Integer.toBinaryString(55));
	}
}
