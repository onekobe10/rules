package com.gankki.demo.designpattern.interpreter.section1;

import java.util.HashMap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public abstract class Expression {
	
	//解析公式和数值,其中var中的key值是是公式中的参数，value值是具体的数字
	public abstract int interpreter(HashMap<String,Integer> var);
}
