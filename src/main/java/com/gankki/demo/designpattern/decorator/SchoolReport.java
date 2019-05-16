package com.gankki.demo.designpattern.decorator;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/16
 */
public abstract class SchoolReport {

	//成绩单的主要展示的就是你的成绩情况
	public abstract void report();
	
	//成绩单要家长签字，这个是最要命的
	public abstract void sign(String name);
}
