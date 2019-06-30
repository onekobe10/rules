package com.gankki.demo.designpattern.visitor.section3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public interface IVisitor {
	
	//可以访问哪些对象
	public void visit(ConcreteElement1 el1);
	
	public void visit(ConcreteElement2 el2);
}
