package com.gankki.demo.designpattern.command.section4;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
public class Invoker {
	private Command command;
	//受气包，接受命令
	public void setCommand(Command _command){
		this.command = _command;
	}
	
	//执行命令
	public void action(){
		this.command.execute();
	}
	
}
