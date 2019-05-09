package com.gankki.demo.gankki.gankki201905;


import java.math.BigDecimal;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class Test20190509 {
	
	public static void main(String[] args){
		System.out.println(0.11 + 2019.32);
		BigDecimal d1 = new BigDecimal(0.11);
		BigDecimal d2 = new BigDecimal(2019.32);
		System.out.println(d1.add(d2));
	}

}
