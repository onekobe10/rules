package com.gankki.demo.designpattern.builder.section;

import java.util.ArrayList;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/18
 */
public class BMWBuilder extends CarBuilder {
	private BMWModel bmw = new BMWModel();
	
	@Override
	public CarModel getCarModel() {
		return this.bmw;
	}

	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.bmw.setSequence(sequence);
	}

}
