package com.gankki.demo.ma.genericity;

import java.util.Arrays;
import java.util.Random;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/9
 */
public class DynamicArray<E> {
	private static final int DEFAULT_CAPACITY = 10;

	private int size;
	private Object[] elementData;

	public DynamicArray() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	}

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

	public void add(E e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
	}

	public E get(int index) {
		return (E)elementData[index];
	}

	public int size() {
		return size;
	}

	public E set(int index, E element) {
		E oldValue = get(index);
		elementData[index] = element;
		return oldValue;
	}

	public static int indexOf(DynamicArray<?> arr, Object elm){
		for(int i=0; i<arr.size(); i++){
			if(arr.get(i).equals(elm)){
				return i;
			}
		}
		return -1;
	}


	public void addAll1(DynamicArray<E> c) {
		for(int i=0; i<c.size; i++){
			add(c.get(i));
		}
	}

	public <T extends E> void addAll2(DynamicArray<T> c) {
		for(int i=0; i<c.size; i++){
			add(c.get(i));
		}
	}

	public void addAll3(DynamicArray<? extends E> c){
		for(int i=0; i<c.size; i++){
			add(c.get(i));
		}
	}

	public E addAll4(DynamicArray<? extends E> c){
		for(int i=0; i<c.size; i++){
			add(c.get(i));
		}
		return null;
	}

	public void addAll5(DynamicArray<E> c){
		for(int i=0; i<c.size; i++){
			add(c.get(i));
		}
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

	public static <D,S extends D> void copy1(DynamicArray<D> dest,
											DynamicArray<S> src){
		for(int i=0; i<src.size(); i++){
			dest.add(src.get(i));
		}
	}

	public <K>void copy2(DynamicArray<K> dest,
								DynamicArray<? extends K> src){
		for(int i=0; i<src.size(); i++){
			dest.add(src.get(i));
		}
	}

	public static <T extends Comparable<T>> T max(DynamicArray<T> arr){
		T max = arr.get(0);
		for(int i=1; i<arr.size(); i++){
			if(arr.get(i).compareTo(max)>0){
				max = arr.get(i);
			}
		}
		return max;
	}

	public static <T extends Comparable<T>> void max2(DynamicArray<T> arr){
		T max = arr.get(0);
		for(int i=1; i<arr.size(); i++){
			if(arr.get(i).compareTo(max)>0){
				max = arr.get(i);
			}
		}
	}

	public void copyTo(DynamicArray<E> dest){
		for(int i=0; i<size; i++){
			dest.add(get(i));
		}
	}

	public static void main(String[] args){
		DynamicArray<Double> arr = new DynamicArray<Double>();
		Random rnd = new Random();
		int size = 1+rnd.nextInt(100);
		for(int i=0; i<size; i++){
			arr.add(Math.random());
		}

		Double d = arr.get(rnd.nextInt(size));

		DynamicArray<Number> numbers = new DynamicArray<>();
		DynamicArray<Integer> ints0 = new DynamicArray<>();
		DynamicArray<Integer> ints1 = new DynamicArray<>();
		ints0.add(100);
		ints0.add(34);
		numbers.addAll2(ints0);


		DynamicArray<Integer> ints = new DynamicArray<>();
		DynamicArray<? extends Number> numbers1 = ints;
		Integer a = 200;
		/*numbers1.add(a);
		numbers1.add((Number)a);
		numbers1.add((Object)a);*/
		ints.add(100);
		ints.add(34);
		DynamicArray<Number> numbers2 = new DynamicArray<Number>();
		//ints.copyTo(numbers2);
	}
}

