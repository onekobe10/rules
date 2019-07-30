package com.gankki.demo.test.stream;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/30
 */
public class SingleFieldStream {
	private String userName;

	public SingleFieldStream(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
