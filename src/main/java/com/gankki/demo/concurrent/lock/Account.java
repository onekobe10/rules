package com.gankki.demo.concurrent.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/11
 */
public class Account {
	private ReentrantLock lock = new ReentrantLock();
	private volatile double money;

	public Account(double initialMoney) {
		this.money = initialMoney;
	}

	public void add(double money) {
		lock.lock();
		try {
			this.money += money;
		} finally {
			lock.unlock();
		}
	}

	public void reduce(double money) {
		System.out.println(lock.getHoldCount());
		lock.lock();
		try {
			this.money -= money;
		} finally {
			lock.unlock();
		}
	}

	public double getMoney() {
		return money;
	}

	void lock() {
		lock.lock();
	}

	void unlock() {
		lock.unlock();
	}

	boolean tryLock() {
		return lock.tryLock();
	}


	public static void main(String[] args){
	    System.out.println(new Random().nextInt(100));
	}



}
