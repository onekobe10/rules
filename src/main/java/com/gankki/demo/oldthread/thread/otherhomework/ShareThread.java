package com.gankki.demo.oldthread.thread.otherhomework;

public class ShareThread {
	private int j;

	
	public ShareThread() {
		super();
	}

	public ShareThread(int j) {
		super();
		this.j = j;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	public void add(){
		System.out.println(getJ() + 1);
	}
	public void minus(){
		System.out.println(getJ() - 1);
	}
}
