package com.gankki.demo.io.printwriter;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class Student {
	private String name;
	private int age;
	private Double score;

	public Student() {
	}

	public Student(String name, int age, Double score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
