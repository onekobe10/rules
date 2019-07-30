package com.gankki.demo.test.stream;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/30
 */
public class StreamBean {
	private String userName;
	private Integer age;

	public StreamBean() {
	}

	public StreamBean(String userName, Integer age) {
		this.userName = userName;
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
