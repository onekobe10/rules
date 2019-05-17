package com.gankki.demo.designpattern.chain;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/17
 */
public class Husband extends Handler {
	//丈夫只处理妻子的请求
	public Husband(){
		super(Handler.HUSBAND_LEVEL_REQUEST);
	}
	
	//丈夫请示的答复
	@Override
	protected void response(IWomen women) {
		System.out.println("--------妻子向丈夫请示-------");
		System.out.println(women.getRequest());
		System.out.println("丈夫的答复是：同意\n");
	}

	/**
	 * final 保证了方法不能重写，但是可以重载
	 * @param women
	 * @param o
	 */
	public final void HandleMessage(IWomen women, Object o){

	}

}
