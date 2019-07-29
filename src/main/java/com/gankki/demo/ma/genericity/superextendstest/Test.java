package com.gankki.demo.ma.genericity.superextendstest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/25
 */
public class Test {

	public static void main(String[] args){
		List<? super C> list = new ArrayList<>();
		list.add(new C());
		list.add(new D());
		// list.add(new A());

		Function function1 = t -> {
					System.out.println("1");
					return new B();
		};

		Function<? super C, ? extends C> function2 = t -> {
			System.out.println("1");
			return new D();
		};

		// PSEC原则 product super, extends consumer
		List<? super C> superList = new ArrayList<>();
		superList.add(new C());
		superList.add(new D());
		// 任何时候都只能增加 C 以及 C 的子类
		//superList.add(new B());
		// 因为 ？ super C 代表了 C 以及 C 的父类，因此可以新增元素
		// super product
		// 因为不能确定父类的类型，所以获取的元素的时候只能是 Object，然后再强转成 C 以及 C 的子类
		for (Object o : superList) {
			System.out.println(o.getClass().getName());
		}
		List<B> bList = new ArrayList<>();
		testSuperArray(bList);


		List<D> dList = new ArrayList<>();
		// 1. 第一种情况
		List<? extends C> extendsList = dList;
		// 因为不能确定子类的类型不能往 ？ extends C 中新增元素，但是因为有上限可以获取元素
		// extends consumer
		//extendsList.add(new D());
		testExtendsArray(dList);
		// 2. 第二种情况
		Function function = c -> new D();
		test(function);

		// 父类能出现的地方，子类一定能出现，里氏代换原则
	}

	public static void testSuperArray(List<? super C> cList) {

	}

	public static void testExtendsArray(List<? extends C> cList) {

	}

	public static void test(Function<? super C, ? extends C> function){
		System.out.println(function.apply(new C()).getClass().getName());
		System.out.println(function.apply(new D()));
	}

}
