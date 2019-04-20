package com.gankki.demo.ma;

import java.util.Arrays;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/12
 */
public class ArrayCopyTest {


	public static void main(String[] args){
	    String[] strArr = {"111", "222", "333"};
		String[] strCopy = Arrays.copyOf(strArr, 5);
		strCopy[4] = "111";
		System.out.println(Arrays.toString(strCopy));
		String[] copy = new String[5];
		System.arraycopy(strArr, 0, copy, 0, 3);
		System.out.println(Arrays.toString(copy));
	}
}
