package com.gankki.demo.concurrent.synctool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class MyCache {
	private Map<String, Object> map = new HashMap<>();
	private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private Lock readLock = readWriteLock.readLock();
	private Lock writeLock = readWriteLock.writeLock();

	public Object get(String key) {
		readLock.lock();
		try {
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public Object put(String key, Object value) {
		writeLock.lock();
		try {
			return map.put(key, value);
		} finally {
			writeLock.unlock();
		}
	}

	public void clear() {
		writeLock.lock();
		try {
			map.clear();
		} finally {
			writeLock.unlock();
		}
	}
}
