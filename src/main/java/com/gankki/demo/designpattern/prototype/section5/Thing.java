package com.gankki.demo.designpattern.prototype.section5;

import java.util.ArrayList;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/11
 */
public class Thing implements Cloneable{
	//定义一个私有变量
	private ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	public Thing clone(){
		Thing thing=null;
		try {
			thing = (Thing)super.clone();	
			this.arrayList = (ArrayList<String>)this.arrayList.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return thing;
	}
	
	//设置HashMap的值
	public void setValue(String value){
		this.arrayList.add(value);
	}
	
	//取得arrayList的值
	public ArrayList<String> getValue(){
		return this.arrayList;
	}
		
}
