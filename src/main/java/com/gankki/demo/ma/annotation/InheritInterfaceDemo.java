package com.gankki.demo.ma.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class InheritInterfaceDemo {

	@Inherited
	@Retention(RetentionPolicy.RUNTIME)
	static @interface Test {
	}

	@Test
	static interface Base {

	}

	static class Child implements Base {

	}

	public static void main(String[] args) throws NoSuchMethodException {
		System.out.println(Child.class.isAnnotationPresent(Test.class));
	}
}
