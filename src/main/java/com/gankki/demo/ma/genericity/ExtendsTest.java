package com.gankki.demo.ma.genericity;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/24
 */
public class ExtendsTest {


	public static void main(String[] args){
		DynamicArray<Integer> ints = new DynamicArray<>();
		DynamicArray<? extends Number> numbers = ints;
		/*Number n = new Double(23.0);
		Object o = new String("hello world");
		numbers.add(n);
		numbers.add(o);*/
	}

	/*public static void swap(DynamicArray<?> arr, int i, int j){
		Object tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}*/

	private static <T> void swapInternal(DynamicArray<T> arr, int i, int j){
		T tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}

	public static void swap(DynamicArray<?> arr, int i, int j){
		swapInternal(arr, i, j);
	}
}
