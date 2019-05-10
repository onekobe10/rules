package com.gankki.demo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/10
 */
public class AtomicArrayDemo {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		AtomicIntegerArray atomicArr = new AtomicIntegerArray(arr);
		atomicArr.compareAndSet(1, 2, 100);
		System.out.println(atomicArr.get(1));
		System.out.println(arr[1]);
	}
}
