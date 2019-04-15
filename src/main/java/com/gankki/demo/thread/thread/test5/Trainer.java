package com.gankki.demo.thread.thread.test5;

public class Trainer extends Thread {

	Mountaion mm;
	public int speed;

	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(Mountaion mm, int speed) {
		super();
		this.mm = mm;
		this.speed = speed;
	}

	public Mountaion getMm() {
		return mm;
	}

	public void setMm(Mountaion mm) {
		this.mm = mm;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {
		synchronized (mm) {
			int time = mm.mile / speed;
			System.out.println(Thread.currentThread().getName() + "����" + time + "����");
			try {
				Thread.currentThread().sleep(time * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "�߳���ɽ��\n");
		}
	}
}
