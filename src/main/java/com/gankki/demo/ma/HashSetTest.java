package com.gankki.demo.ma;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {


	public static void main(String[] args){
		Set<Spec> set = new HashSet<>();
		Spec spec1 = new Spec("M","red");
		Spec spec2 = new Spec("M","red");
		set.add(spec1);
		set.add(spec2);

		System.out.println(set);

		System.out.println(spec1.hashCode());
		System.out.println(spec2.hashCode());
	}
}

