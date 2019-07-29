package com.gankki.demo.test.breakcontinue;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/29
 */
public class BreakTest {


	public static void main(String[] args){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == j) {
					break;
				}
			}
			System.out.println(i + "...........");
		}
	}
}
