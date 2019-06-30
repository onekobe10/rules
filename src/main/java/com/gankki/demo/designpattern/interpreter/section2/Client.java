package com.gankki.demo.designpattern.interpreter.section2;

import java.util.Stack;

/**
 *@desc 常该类为一个封装类常该类为一个封装类
 *@author liuhao
 *@createDate 2019/6/30
 */
@SuppressWarnings("all")
public class Client {
	private static Context ctx;
	private static Stack<Expression> stack;

	public static void main(String[] args) {
		ctx = new Context();
		//通常定一个语法容器，容纳一个具体的表达式，通常为ListArray,LinkedList,Stack等类型
		stack = new Stack<Expression>();
		stack.add(new TerminalExpression());
		/*
		for(;;){
			//进行语法判断，并产生递归调用
		}
		*/
		//产生一个完整的语法树，由各各个具体的语法分析进行解析
		Expression exp = stack.pop();
		
		//具体元素进入场景
		exp.interpreter(ctx);
	}
}
