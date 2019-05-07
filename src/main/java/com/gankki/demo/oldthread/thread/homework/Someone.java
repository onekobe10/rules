package com.gankki.demo.oldthread.thread.homework;

public class Someone implements Runnable {

	private String name;
	private int speed;
	Cove theCove;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Cove getTheCove() {
		return theCove;
	}

	public void setTheCove(Cove theCove) {
		this.theCove = theCove;
	}

	public Someone(String name, int speed, Cove theCove) {
		super();
		this.name = name;
		this.speed = speed;
		this.theCove = theCove;
	}

	public Someone() {
		super();
	}

	@Override
	public void run() {
		synchronized (theCove) {

			System.out.println(this.getName() + "��ʼ����ɽ���ˡ�������������������");
			try {
				Thread.currentThread().sleep((theCove.getDistant() / this.speed) * 1000);
				System.out.println("�ɹ�����ɽ����������" + theCove.getDistant() / this.speed + "��");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
