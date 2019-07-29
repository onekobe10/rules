package com.gankki.demo.ma.genericity.superextendstest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/29
 */
public class CollectionTest {
	
	
	public static void main(String[] args){
		List<C> dest = new ArrayList<>(3);
		dest.add(new D());
		dest.add(new D());
		dest.add(new D());
		List<C> src = new ArrayList<>(3);
		src.add(new C());
		src.add(new C());
		src.add(new C());
		/**
		 * 1. PESC 第一种使用场景，限制容器中元素的增加和读取
		 * 可以通过 PESC 原则限制方法中对方法参数为容器的增加和获取
		 */
		Collections.copy(dest, src);
		/**
		 * 在方法之后容器的增加和获取不受影响
		 */
		System.out.println(dest.get(0).getClass().getName());

		/**
		 *
		 * 2. PESC 原则 第二种使用场景 父类存在的地方，子类也能存在，里氏代换原则的应用
		 * public static <T, K, U> Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
		 *                                     Function<? super T, ? extends U> valueMapper) {
		 *         return toMap(keyMapper, valueMapper, throwingMerger(), HashMap::new);
		 *    }
		 *
		 *
		 */
	}
	
}


