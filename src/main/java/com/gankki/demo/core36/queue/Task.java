package com.gankki.demo.core36.queue;

public class Task {
	int priority;
	String name;

	public Task(int priority, String name) {
		this.priority = priority;
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public String getName() {
		return name;
	}

}
