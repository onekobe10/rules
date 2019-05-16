package com.gankki.demo.designpattern.singleton;

/**
 *@desc	测试单例
 *@author liuhao
 *@createDate 2019/5/16
 */
public class Test {

	private static  final Test FULL_SINGLETON = new Test();
	private static final Integer testFinal = null;

	// private final Integer testFinal2;

	private String ss = "1";

	private Test(){

	}

	public  static Test getInstance(){
		/**
		 * 不能在静态方法中引用非静态的成员变量
		 *
		 * 静态方法和属性属于类的方法和属，不能在静态方法中引用实例对象的方法和属性
		 *
		 *
		 */
		//System.out.println(ss);
		return FULL_SINGLETON;
	}

	/**
	 * 一个常量，只能在声明的时候被明确赋值,如果没有赋值则不能通过编译，即使是null也可以，被赋值的常量之后不能再被修改。
	 * @param args
	 */
	public static void main(String[] args){
	    Test test = new Test();

	    // test.testFinal = 1;
		// test.testFinal2 = 1;
	}
}
