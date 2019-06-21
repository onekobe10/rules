/**
 * 
 */
package com.gankki.demo.designpattern.strategy.example;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/19
 */
public class BlockEnemy implements IStrategy {

	@Override
	public void operate() {
		System.out.println("孙夫人断后，挡住追兵");
	}

}
