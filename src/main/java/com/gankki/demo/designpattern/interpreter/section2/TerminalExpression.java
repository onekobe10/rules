package com.gankki.demo.designpattern.interpreter.section2;

/**
 *@desc 终结符表达式
 *@author liuhao
 *@createDate 2019/6/30
 */
public class TerminalExpression extends Expression {
	

	//通常终结符表达式只有一个，但是有多个对象
	public Object interpreter(Context ctx) {	
		return null;
	}

}
