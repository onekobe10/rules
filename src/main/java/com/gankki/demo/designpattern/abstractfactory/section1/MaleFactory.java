package com.gankki.demo.designpattern.abstractfactory.section1;

public class MaleFactory implements HumanFactory {

	//生产出黑人男性
	@Override
	public Human createBlackHuman() {
		return new MaleBlackHuman();
	}

	//生产出白人男性
	@Override
	public Human createWhiteHuman() {
		return new MaleWhiteHuman();
	}

	//生产出黄人男性
	@Override
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}

}
