package com.gankki.demo.designpattern.state.example;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class Client {
	
	public static void main(String[] args) {
		// 隐藏了状态的变化过程，它的切换引起了行为的变化
		// 我们只看到了行为发生了改变，而不用知道是状态变化引起的
		Context context = new Context();
		context.setLiftState(new ClosingState());
		
		context.open();
		context.close();
		context.run();
		context.stop();
		context.open();
	}
}
