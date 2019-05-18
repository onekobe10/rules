package com.gankki.demo.designpattern.abstractfactory.section1;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/18
 */
public abstract class AbstractYellowHuman implements Human {

	@Override
	public void getColor(){
		System.out.println("黄色人种的皮肤颜色是黄色的！");
	}

	@Override
	public void talk() {
		System.out.println("黄色人种会说话，一般说的都是双字节。");
	}
}
