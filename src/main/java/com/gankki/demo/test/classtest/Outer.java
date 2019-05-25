package com.gankki.demo.test.classtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/20
 */
public class Outer {

	public Outer() {
		// 构造方法中的匿名内部类
		InnerClass innerClass = new InnerClass() {
			@Override
			public void fun() {
				getEnclosing(this.getClass());
				/**
				 * enclosingClass=class reflect.Outer
				 * enclosingConstructor=public reflect.Outer()
				 * enclosingMethod=null
				 */
			}
		};
		innerClass.fun();
	}

	// 匿名内部类
	static InnerClass innerClass = new InnerClass() {
		@Override
		public void fun() {
			getEnclosing(this.getClass());
			/**
			 * enclosingClass=class reflect.Outer
			 * enclosingConstructor=null
			 * enclosingMethod=null
			 */
		};
	};

	public static void test() {
		// 方法中的匿名内部类
		InnerClass innerClass = new InnerClass() {
			@Override
			public void fun() {
				getEnclosing(this.getClass());
				/**
				 * enclosingClass=class reflect.Outer
				 * enclosingConstructor=null
				 * enclosingMethod=public static void reflect.Outer.test()
				 */

			}
		};
		innerClass.fun();
	}

	// 内部类
	public static class InnerClass {
		public InnerClass() {

		}

		public void fun() {
			System.out.println("11");
		}
	}

	public static void main(String[] args) {
		System.out.println("------内部类------");
		getEnclosing(InnerClass.class);

		System.out.println("------匿名内部类------");
		innerClass.fun();

		System.out.println("------方法中的匿名内部类------");
		Outer.test();

		System.out.println("------构造函数中的匿名内部类------");
		new Outer();

		Outer.InnerClass oi = new Outer.InnerClass();
		oi.fun();
	}

	/**
	 * getEnclosingClass:如果当前Class为内部类，获取直接包含该类的类
	 * getEnclosingConstructor：如果当前Class为本地类或匿名内部类，返回包含它的类的构造方法
	 * getEnclosingMethod：如果当前Class为本地类或匿名内部类，返回包含它的类的方法
	 *
	 * @param cls
	 */
	private static void getEnclosing(Class cls) {
		Class enclosingClass = cls.getEnclosingClass();
		Constructor enclosingConstructor = cls.getEnclosingConstructor();
		Method enclosingMethod = cls.getEnclosingMethod();
		System.out.println("enclosingClass=" + enclosingClass);
		System.out.println("enclosingConstructor=" + enclosingConstructor);
		System.out.println("enclosingMethod=" + enclosingMethod);
	}

	private static void getDecalared() {

	}

}
