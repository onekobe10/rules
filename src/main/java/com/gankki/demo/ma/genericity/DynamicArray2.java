package com.gankki.demo.ma.genericity;

import java.util.Arrays;

public class DynamicArray2<T> {
	private static final int DEFAULT_CAPACITY = 10;

	private int size;
	private Object[] elementData;

	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		if(oldCapacity>=minCapacity){
			return;
		}
		int newCapacity = oldCapacity * 2;
		if (newCapacity < minCapacity)
			newCapacity = minCapacity;
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	public <T> void add(T e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
	}

	public <E extends T> void add2(E e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
	}

	public void add3(DynamicArray2<? extends T> e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
	}

	public static <E>void add4(DynamicArray<E> e) {
	}

}
