package com.gankki.demo.designpattern.mediator.section2;

/**
 *@desc 同事类
 *@author liuhao
 *@createDate 2019/6/17
 */
public abstract class Colleague {
	protected Mediator mediator;
	public Colleague(Mediator _mediator){
		this.mediator = _mediator;
	}
}
