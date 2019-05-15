package com.gankki.demo.concurrent.synctool;

import java.util.concurrent.Semaphore;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class SemaphoreDemo {


	public static void main(String[] args) throws Exception{
		Semaphore permits = new Semaphore(1);
		permits.acquire();
		permits.acquire();
		System.out.println("acquired");
	}
}
