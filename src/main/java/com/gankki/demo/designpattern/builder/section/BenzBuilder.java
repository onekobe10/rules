package com.gankki.demo.designpattern.builder.section;

import java.util.ArrayList;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/18
 */
public class BenzBuilder extends CarBuilder {
	private BenzModel benz = new BenzModel();

	@Override
	public CarModel getCarModel() {
		return this.benz;
	}


	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.benz.setSequence(sequence);
	}

}
