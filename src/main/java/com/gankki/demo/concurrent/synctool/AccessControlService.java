package com.gankki.demo.concurrent.synctool;

import java.util.concurrent.Semaphore;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class AccessControlService {
	public static class ConcurrentLimitException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

	private static final int MAX_PERMITS = 100;
	private Semaphore permits = new Semaphore(MAX_PERMITS, true);

	public boolean login(String name, String password) {
		if (!permits.tryAcquire()) {
			// 同时登录用户数超过限制
			throw new ConcurrentLimitException();
		}
		// ..其他验证
		return true;
	}

	public void logout(String name) {
		permits.release();
	}
}
