package com.gankki.demo.ma.enumset;

import java.util.Set;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/2
 */
public class Worker {
	String name;
	Set<Day> availableDays;

	public Worker(String name, Set<Day> availableDays) {
		this.name = name;
		this.availableDays = availableDays;
	}

	public String getName() {
		return name;
	}

	public Set<Day> getAvailableDays() {
		return availableDays;
	}
}
