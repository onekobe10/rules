package com.gankki.demo.test.bigdecimal;

import java.math.BigDecimal;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/30
 */
public class Test2 {

	public static void main(String[] args){
		BigDecimal bigDecimal = new BigDecimal("2.808");
		bigDecimal.setScale(4);
		System.out.println(bigDecimal.toString());
	}

}
