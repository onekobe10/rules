package com.gankki.demo.designpattern.interpreter.section1;

import java.util.HashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class AddExpression extends SymbolExpression {

	public AddExpression(Expression _left,Expression _right){
		super(_left,_right);
	}
	
	//把左右两个表达式运算的结果加起来
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) + super.right.interpreter(var);
	}

}
