package com.gankki.demo.designpattern.mediator.section2;

/**
 *@desc 同事的抽象类
 *@author liuhao
 *@createDate 2019/6/11
 */
public abstract class AbstractColleague {
	protected AbstractMediator mediator;
	public AbstractColleague(AbstractMediator _mediator){
		this.mediator = _mediator;
	}
}
