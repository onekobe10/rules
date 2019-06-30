package com.gankki.demo.designpattern.interpreter.section1;

import java.util.HashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class VarExpression extends Expression {
	private String key;
	
	public VarExpression(String _key){
		this.key = _key;
	}
	
	//从map中取之
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}

}
