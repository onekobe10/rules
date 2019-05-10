package com.gankki.demo.concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/10
 */
public class AtomicStampedReferenceDemo {

	private static class Pair<T> {
		final T reference;
		final int stamp;
		private Pair(T reference, int stamp) {
			this.reference = reference;
			this.stamp = stamp;
		}
		static <T> Pair<T> of(T reference, int stamp) {
			return new Pair<T>(reference, stamp);
		}
	}

	public static void main(String[] args){
		Pair pair = new Pair(100, 200);
		int stamp = 1;
		// pairRef中的stamp为1
		AtomicStampedReference<Pair> pairRef = new AtomicStampedReference<>(pair, stamp);
		int newStamp = 2;

		System.out.println(pairRef.getReference().reference);
		System.out.println(pairRef.getReference().stamp);
		/**
		 * 修改成功有两个条件：
		 * 	1.pair中的属性和pairRef中的属性相同
		 * 	2.stamp的值和pairRef中的属性相同
		 * 	如果满足这两个条件，则将pair和stamp都改为新的引用即可
		 * 	即需要修改两个值，1.引用的值2.时间戳的值
		 */
		pairRef.compareAndSet(pair, new Pair(200, 300), stamp, newStamp);

		System.out.println(pairRef.getReference().reference);
		System.out.println(pairRef.getReference().stamp);
	}
}
