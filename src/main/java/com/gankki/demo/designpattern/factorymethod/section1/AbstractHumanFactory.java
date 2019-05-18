package com.gankki.demo.designpattern.factorymethod.section1;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/18
 */
public abstract class AbstractHumanFactory {

	public abstract <T extends Human> T createHuman(Class<T> c);
	
}