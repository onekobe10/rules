package com.gankki.demo.designpattern.visitor.section3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public abstract class Element {
	/*#com.company.visitor.section3.IVisitor lnkIVisitor*/
//定义业务逻辑
	public abstract void doSomething();
	
	//允许谁来访问
	public abstract void accept(IVisitor visitor);
}
