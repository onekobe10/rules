package com.gankki.demo.ma.annotation.example;

import java.util.Date;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
public class Student {
	@Label("姓名")
	String name;

	@Label("出生日期")
	@Format(pattern="yyyy/MM/dd")
	Date born;

	@Label("分数")
	double score;

	public Student() {
	}

	public Student(String name, Date born, Double score) {
		super();
		this.name = name;
		this.born = born;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", born=" + born + ", score=" + score + "]";
	}
}
