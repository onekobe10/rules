/**
 * 
 */
package com.gankki.demo.designpattern.strategy.example;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/19
 */
public class BackDoor implements IStrategy {

	@Override
	public void operate() {
		System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
	}

}