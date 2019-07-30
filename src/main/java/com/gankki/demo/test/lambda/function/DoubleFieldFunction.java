package com.gankki.demo.test.lambda.function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/29
 */
public class DoubleFieldFunction {
	private String name;
	private Integer age;

	public DoubleFieldFunction(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
