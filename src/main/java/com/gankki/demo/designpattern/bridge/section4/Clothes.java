package com.gankki.demo.designpattern.bridge.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/1
 */
public class Clothes extends Product {
	@Override
	public void beProducted() {
		System.out.println("生产出的衣服是这个样子的...");
	}
	@Override
	public void beSelled() {
		System.out.println("生产出的衣服卖出去了...");
	}
}


