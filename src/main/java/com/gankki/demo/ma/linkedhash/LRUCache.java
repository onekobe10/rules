package com.gankki.demo.ma.linkedhash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/1
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private int maxEntries;

	public LRUCache(int maxEntries){
		super(16, 0.75f, true);
		this.maxEntries = maxEntries;
	}

	/**
	 * **********************
	 * 使用LinkedHashMap，可以非常容易的实现LRU缓存
	 * 默认情况下，LinkedHashMap没有对容量做限制，但它可以容易的做的，它有一个protected方法removeEldestEntry
	 * 在添加元素到LinkedHashMap后，LinkedHashMap会调用这个方法，传递的参数是最久没被访问的键值对，
	 * 如果这个方法返回true，则这个最久的键值对就会被删除。
	 * LinkedHashMap的实现总是返回false，所有容量没有限制，但子类可以重写该方法，在满足一定条件的情况，返回true。
	 * @param eldest
	 * @return
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return size() > maxEntries;
	}

	/**
	 * 访问顺序是什么意思呢？所谓访问是指get/put操作，对一个键执行get/put操作后，其对应的键值对会移到链表末尾，
	 * 所以，最末尾的是最近访问的，最开始的最久没被访问的，这种顺序就是访问顺序。
	 * @param args
	 */
	public static void main(String[] args){
		LRUCache<String,Object> cache = new LRUCache<>(3);
		cache.put("a", "abstract");
		cache.put("b", "basic");
		cache.put("c", "call");
		cache.get("a");

		cache.put("d", "call");
		System.out.println(cache);
	}
}
