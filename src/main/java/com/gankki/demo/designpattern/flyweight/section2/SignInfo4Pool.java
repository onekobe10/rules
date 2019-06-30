package com.gankki.demo.designpattern.flyweight.section2;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/30
 */
public class SignInfo4Pool extends SignInfo {
	
	//定义一个对象池提取的KEY值
	private String key;
	
	//构造函数获得相同标志
	public SignInfo4Pool(String _key){
		this.key = _key;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
