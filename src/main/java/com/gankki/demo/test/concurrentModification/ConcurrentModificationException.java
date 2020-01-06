package com.gankki.demo.test.concurrentModification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/28
 */
public class ConcurrentModificationException {


	/**
	 * 迭代器内部会维护一些索引位置相关的数据，要求在迭代过程中，容器不能发生结构性变化，否则这些索引位置就失效了。
	 * 所谓结构性变化就是添加、插入和删除元素，只是修改元素内容不算结构性变化。
	 *
	 *  cursor表示下一个要返回的元素位置
	 *  lastRet表示最后一个返回的索引位置,也就是当前next返回元素的索引位置
	 *  expectedModCount表示期望的修改次数
	 *
	 *  checkForComodification() 方法以及下标是否超出容器的长度判断都是为了检测在遍历的过程中是否出现了结构性变化。
	 * @param args
	 */
	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("1","2","3","4","5"));

		try {
			for (String str : list) {
				if ("1".equals(str)) {
					/**
					 *
					 * list的remove方法导致了expectedModCount与modCount不相同，也就是在迭代的过程中检测出了结构性变化，抛出了此异常。
					 * 虽然抛出了异常，但是list还是删除了指定的元素
					 */
					list.remove("1");
				}
			}
		} catch (Exception e){
			System.out.println("ConcurrentModificationException 并发修改异常");
		}

		Iterator it = list.iterator();
		/**
		 * 需要注意的是，调用remove方法前必须先调用next,获取当前迭代对象的下标lastRet 1
		 */
		while (it.hasNext()) {
			if (it.next().equals("3")) {
				it.remove();
			}
		}

		System.out.println(list);


	}
}
