package com.gankki.demo.designpattern.mediator.section3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/11
 */
public class Client {
	
	public static void main(String[] args) {
		AbstractMediator mediator = new Mediator();

		// 中介者和它的协调对象必须互相持有对方的引用
		Purchase purchase = new Purchase(mediator);
		Sale sale = new Sale(mediator);
		Stock stock = new Stock(mediator);

		mediator.setPurchase(purchase);
		mediator.setSale(sale);
		mediator.setStock(stock);
		// 中介者和它的协调对象必须互相持有对方的引用

		//采购人员采购电脑
		System.out.println("------采购人员采购电脑--------");
		purchase.buyIBMcomputer(100);

		//销售人员销售电脑
		System.out.println("\n------销售人员销售电脑--------");
		sale.sellIBMComputer(1);

		//库房管理人员管理库存
		System.out.println("\n------库房管理人员清库处理--------");
		stock.clearStock();
	}

}
