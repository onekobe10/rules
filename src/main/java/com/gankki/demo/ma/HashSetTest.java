package com.gankki.demo.ma;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {


	/**
	 * 如果没有重写hashcode方法，对象的hashcode值是根据内存地址生成的，
	 * 这样会导致相同属性的不同实例对象都可以添加到set容器中去，因此需要重写Object的hashcode方法和equals方法
	 *
	 * HashSet内部是HashMap实现的，value为Object
	 * TreeSet内部是TreeMap实现的，value为Object
	 * LinkedHashSet是HashSet的子类，但是调用的是HashSet中LinkedHashMap的构造方法，value也为Object
	 *
	 * Set容器的输出顺序为hash数据的顺序，是按对象的hash值排列的
	 *
	 * @param args
	 */
	public static void main(String[] args){
		Set<Spec> set = new HashSet<>();
		Spec spec1 = new Spec("M","red");
		Spec spec2 = new Spec("M","red");
		set.add(spec1);
		set.add(spec2);

		System.out.println(set);

		System.out.println(spec1.hashCode());
		System.out.println(spec2.hashCode());

		Set<String> test = new HashSet();
		test.add("1");
		test.add("3");
		test.add("2");
		test.add("4");

		System.out.println(test.toString());

	}
}

