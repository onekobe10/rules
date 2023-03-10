package com.gankki.demo.designpattern.strategy.self;

public abstract class AbstractIStrategy implements IStrategy {

    @Override
    public void operate() {
        System.out.println("抽象类实现");
        doOperate();
        doOperate2();
    }

    protected abstract void doOperate();

    protected abstract void doOperate2();

}
