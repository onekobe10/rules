package com.gankki.demo.designpattern.composite.section3;

/**
 *@desc 组装这个树形结构，并展示出来
 *@author liuhao
 *@createDate 2019/6/23
 */
public class Leaf extends Corp {
	
	//就写一个构造函数，这个是必须的
	public Leaf(String _name,String _position,int _salary){
		super(_name,_position,_salary);
	}
}
