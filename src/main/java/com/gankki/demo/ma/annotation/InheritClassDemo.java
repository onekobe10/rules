package com.gankki.demo.ma.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class InheritClassDemo {

	@Inherited
	@Retention(RetentionPolicy.RUNTIME)
	static @interface Test {
	}

	@Test
	static class Base {

		@Test
		public void test(){

		}
	}

	static class Child extends Base {

		@Override
		public void test(){

		}
	}

	public static void main(String[] args) throws NoSuchMethodException {
		System.out.println(Child.class.isAnnotationPresent(Test.class));
		System.out.println(Child.class.getMethod("test").isAnnotationPresent(Test.class));
	}
}
