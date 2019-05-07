package com.gankki.demo.oldthread.thread.test4;

public class TicketsGate extends Thread{

	TicketsBox tbox;
	
	public TicketsGate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketsGate(TicketsBox tbox) {
		super();
		this.tbox = tbox;
	}

	@Override
	public void run() {
		
		while(true){
			synchronized (tbox) {
				if (tbox.getTicketsTotal() > 0) {
					System.out.println(Thread.currentThread().getName() + "���˵�" + tbox.getTicketsTotal() + "��Ʊ");
					tbox.setTicketsTotal(tbox.getTicketsTotal() - 1);
				} else {
					// System.out.println("û��Ʊ�ˣ�������");
					break;
				}
			}
		}
		
	}

}
