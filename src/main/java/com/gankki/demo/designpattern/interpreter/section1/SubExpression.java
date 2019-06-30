package com.gankki.demo.designpattern.interpreter.section1;

import java.util.HashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class SubExpression extends SymbolExpression {

	public SubExpression(Expression _left,Expression _right){
		super(_left,_right);
	}

	//解析就是减法运算
	public int interpreter(HashMap<String, Integer> var) {
		return super.left.interpreter(var) - super.right.interpreter(var);
	}

}
