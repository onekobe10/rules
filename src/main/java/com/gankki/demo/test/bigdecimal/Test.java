package com.gankki.demo.test.bigdecimal;

import java.math.BigDecimal;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/23
 */
public class Test {


	public static void main(String[] args){
	    // 最常用的四舍五入
		BigDecimal bigDecimal1 = new BigDecimal("1.005").setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal bigDecimal2 = BigDecimal.valueOf(1.004).setScale(2, 4);
		System.out.println(bigDecimal1.toString());
		System.out.println(bigDecimal2.toString());

	}
}
