package com.gankki.demo.designpattern.abstractfactory.section1;

public class FemaleFactory implements HumanFactory {

	@Override
	public Human createBlackHuman() {
		return new FemaleBlackHuman();
	}

	@Override
	public Human createWhiteHuman() {
		return new FemaleWhiteHuman();
	}

	@Override
	public Human createYellowHuman() {
		return new FemaleYellowHuman();
	}

}
