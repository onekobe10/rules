package com.gankki.demo.ma.genericity;

import java.util.ArrayList;

public class Base implements Comparable<Base> {
	private int sortOrder;

	public Base(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compareTo(Base o) {
		if (sortOrder < o.sortOrder) {
			return -1;
		} else if (sortOrder > o.sortOrder) {
			return 1;
		} else {
			return 0;
		}
	}


	public static void main(String[] args){
		DynamicArray<Child> childs = new DynamicArray<Child>();
		childs.add(new Child(20));
		childs.add(new Child(80));
		Child maxChild = max(childs);

		ArrayList list = new ArrayList<Integer>();
		list.add("aaa");
		System.out.println(list);

	}

	public static <T extends Comparable<? super T>> T max(DynamicArray<T> arr){
		T max = arr.get(0);
		for(int i=1; i<arr.size(); i++){
			if(arr.get(i).compareTo(max)>0){
				max = arr.get(i);
			}
		}
		return max;
	}
}

class Child extends Base {
	public Child(int sortOrder) {
		super(sortOrder);
	}
}
