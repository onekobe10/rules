package com.gankki.demo.concurrent.threadlocal;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/15
 */
public class RequestContext {
	public static class Request { //...
	}

	/**
	 * 在首次获取到信息时，调用set方法如setCurrentRequest/setCurrentUserId进行设置，
	 * 然后就可以在代码的任意其他地方调用get相关方法进行获取了。
	 *
	 */
	private static ThreadLocal<String> localUserId = new ThreadLocal<>();
	private static ThreadLocal<Request> localRequest = new ThreadLocal<>();

	public static String getCurrentUserId() {
		return localUserId.get();
	}

	public static void setCurrentUserId(String userId) {
		localUserId.set(userId);
	}

	public static Request getCurrentRequest() {
		return localRequest.get();
	}

	public static void setCurrentRequest(Request request) {
		localRequest.set(request);
	}
}
