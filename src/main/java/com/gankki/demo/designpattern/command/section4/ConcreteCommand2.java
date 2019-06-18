package com.gankki.demo.designpattern.command.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
public class ConcreteCommand2 extends Command {	
	//声明自己的默认接收者
	public ConcreteCommand2(){
		super(new ConcreteReciver2());
	}	
	//设置新的接收者
	public ConcreteCommand2(Receiver _receiver){
		super(_receiver);
	}	
	//每个具体的命令都必须实现一个命令
	public void execute() {
		//业务处理
		super.receiver.doSomething();
	}
}
