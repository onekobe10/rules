package com.gankki.demo.test.lambda.function;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/26
 */
public class SingleFieldFunction {
	private String xxx;

	public SingleFieldFunction(String xxx) {
		this.setXxx(xxx);
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}
}
