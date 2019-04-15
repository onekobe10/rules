package com.gankki.demo.gankki.gankki201901;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试容器固定和添加size的区别
 */
public class Test20180118 {


	/**
	 * 初始化的capacity,并不能限制容器存储数据的size，只是会初始化一个size，避免频繁创建新数据的开销
	 * @param args
	 */
	public static void main(String[] args){
		List<String> list = new ArrayList<>(2);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		System.out.println(list.size());
	}
}
