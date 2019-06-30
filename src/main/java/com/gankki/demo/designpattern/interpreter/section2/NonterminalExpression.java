package com.gankki.demo.designpattern.interpreter.section2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class NonterminalExpression extends Expression {
	
	//每个非终结符表达式都会对其他表达式产生依赖
	public NonterminalExpression(Expression... expression){
		
	}
	
	public Object interpreter(Context ctx) {
		//进行文法处理
		return null;
	}

}
