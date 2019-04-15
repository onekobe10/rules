package com.gankki.demo.thread.thread.test;

public class Test2 {
	public static void main(String[] args) {
		
		int a = 0 ;
		FirstThread f1 = new FirstThread();
		f1.setName("�߳� һ ");
		f1.setPriority(10);
		f1.setDaemon(false);
		f1.start();
		

		int i = 0;
		while(true){
			if (i % 1000000000 == 0) {
				a++;
				System.out.println("��ã�С�¡�");
				if (a == 3) {
					break;
				}
			}
			i++;
		}

	}
}
