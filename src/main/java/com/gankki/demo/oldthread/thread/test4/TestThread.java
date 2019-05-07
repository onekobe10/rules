package com.gankki.demo.oldthread.thread.test4;

public class TestThread {

	public static void main(String[] args) {
		
		TicketsBox tbox = new TicketsBox(100);
		TicketsGate tGate1 = new TicketsGate(tbox);
		TicketsGate tGate2 = new TicketsGate(tbox);
		TicketsGate tGate3 = new TicketsGate(tbox);
		TicketsGate tGate4 = new TicketsGate(tbox);
		TicketsGate tGate5 = new TicketsGate(tbox);
		
		tGate1.start();
		tGate2.start();
		tGate3.start();
		tGate4.start();
		tGate5.start();
		
	}

}
