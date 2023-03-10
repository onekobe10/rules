package com.gankki.demo.designpattern.strategy.self;

/**
 *
 * @auth liuhao
 * @version 1.0
 * @date 2023/3/8 10:38
 */
public class StrategyImplTwo extends AbstractIStrategy {


    @Override
    protected void doOperate() {
        System.out.println("策略实现-2");
    }

    @Override
    protected void doOperate2() {
        System.out.println("策略实现-2");
    }

}
