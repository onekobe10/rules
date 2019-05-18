package com.gankki.demo.designpattern.factorymethod.section2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/18
 */
public class WhiteHuman implements Human {

	@Override
	public void getColor(){
		System.out.println("白色人种的皮肤颜色是白色的！");
	}

	@Override
	public void talk() {
		System.out.println("白色人种会说话，一般都是但是单字节。");

	}
	
}
