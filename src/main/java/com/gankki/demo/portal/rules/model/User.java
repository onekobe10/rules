package com.gankki.demo.portal.rules.model;

import java.io.Serializable;

public class User  implements Serializable{
	/**
	 * 默认生成的序列化ID	
	 */
	private static final long serialVersionUID = -6999859056780112511L;
	private String id;
	private String username;
	private String password;
	private Integer age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
