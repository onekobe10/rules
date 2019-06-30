package com.gankki.demo.designpattern.interpreter.section2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public abstract class Expression {
	
	//每个表达式必须有一个解析任务
	public abstract Object interpreter(Context  ctx);
}
