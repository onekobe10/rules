package com.gankki.demo.ma.genericity;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/7
 */
public class Pair<U, V> {

	U first;
	V second;

	public Pair(U first, V second){
		this.first = first;
		this.second = second;
	}

	public U getFirst() {
		return first;
	}

	public V getSecond() {
		return second;
	}


	public static void main(String[] args){
	    // Pair<int,int> pair = new Pair<int, int>();

		Integer[] ints = new Integer[10];
		Number[] numbers = ints;
		Object[] objs = ints;

		Number n = 1;
		Integer i =  (Integer) n;
	}
}