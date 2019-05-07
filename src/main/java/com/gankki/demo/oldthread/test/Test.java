package com.gankki.demo.oldthread.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test {
	
	public static void main(String[] args) {
		AtomicInteger ai = new AtomicInteger();
		Integer integer = new Integer(1);
		AtomicStampedReference<Integer> asr = new AtomicStampedReference<Integer>(19, 0);
		asr.compareAndSet(19, asr.getReference() + 20 , asr.getStamp(), asr.getStamp() + 1);
		//asr.compareAndSet(expectedReference, newReference, expectedStamp, newStamp);
		ThreadLocal<String> ss = null;
		
	}
}
