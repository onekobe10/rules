package com.gankki.demo.ma.genericity;

public class NumberPair<U extends Number, V extends Number> extends Pair<U, V> {

	public NumberPair(U first, V second) {
		super(first, second);
	}


	public static void main(String[] args){
		NumberPair<Number, Number> numberPair = new NumberPair<>(1, 2);
	}

	public static <T extends Comparable<T>> T max(T[] arr){
		T max = arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i].compareTo(max)>0){
				max = arr[i];
			}
		}
		return max;
	}

}
