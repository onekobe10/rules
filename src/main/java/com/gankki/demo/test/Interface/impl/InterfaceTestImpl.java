package com.gankki.demo.test.Interface.impl;

import com.gankki.demo.test.Interface.InterfaceTest;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/27
 */
public class InterfaceTestImpl implements InterfaceTest {

	@Override
	public String testPublic() {
		System.out.println("subClass impl");
		return null;
	}


	public static void main(String[] args){
		InterfaceTest interfaceTest = new InterfaceTestImpl();
		interfaceTest.testPublic();
		interfaceTest.testDefault();
		InterfaceTest.testStatic();

	}
}
