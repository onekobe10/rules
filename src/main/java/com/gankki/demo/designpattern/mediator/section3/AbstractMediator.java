package com.gankki.demo.designpattern.mediator.section3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/11
 */
public abstract class AbstractMediator {
	protected Purchase purchase;
	protected Sale sale;
	protected Stock stock;

	//中介者最重要的方法，叫做事件方法，处理多个对象之间的关系
	public abstract void execute(String str,Object...objects);

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}