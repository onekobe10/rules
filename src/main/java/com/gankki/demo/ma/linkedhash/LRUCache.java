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
