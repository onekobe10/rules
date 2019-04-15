package com.gankki.demo.ma.enummap;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/1
 */
public class Clothes {
	String id;
	Size size;

	public Clothes(String id, Size size) {
		this.id = id;
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public Size getSize() {
		return size;
	}
}
