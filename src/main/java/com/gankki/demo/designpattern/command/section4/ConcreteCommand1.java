package com.gankki.demo.designpattern.command.section4;


/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
public class ConcreteCommand1 extends Command {
	//声明自己的默认接收者
	public ConcreteCommand1(){
		super(new ConcreteReciver1());
	}	
	//设置新的接收者
	public ConcreteCommand1(Receiver _receiver){
		super(_receiver);
	}	
	//每个具体的命令都必须实现一个命令
	public void execute() {
		//业务处理
		super.receiver.doSomething();
	}
}
