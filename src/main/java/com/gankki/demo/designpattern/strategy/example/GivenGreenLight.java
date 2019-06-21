/**
 * 
 */
package com.gankki.demo.designpattern.strategy.example;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/19
 */
public class GivenGreenLight implements IStrategy {

	@Override
	public void operate() {
		System.out.println("求吴国太开个绿灯,放行！");
	}

}
