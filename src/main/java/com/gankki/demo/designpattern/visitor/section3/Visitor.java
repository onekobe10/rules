package com.gankki.demo.designpattern.visitor.section3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Visitor implements IVisitor {

	//访问el1元素
	@Override
	public void visit(ConcreteElement1 el1) {
		el1.doSomething();
	}

	//访问el2元素
	@Override
	public void visit(ConcreteElement2 el2) {
		el2.doSomething();
	}
}
