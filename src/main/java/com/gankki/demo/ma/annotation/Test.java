package com.gankki.demo.ma.annotation;

import java.util.Date;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class Test {
	
	@SuppressWarnings({"deprecation","unused","all"})
	public static void main(String[] args){
		Date date = new Date(2017, 4, 12);
		int year = date.getYear();
	}
}
