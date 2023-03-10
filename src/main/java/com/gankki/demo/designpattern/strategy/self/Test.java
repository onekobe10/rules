package com.gankki.demo.designpattern.strategy.self;

/**
 *
 * @auth liuhao
 * @version 1.0
 * @date 2023/3/8 10:39
 */
public class Test {

    public static void main(String[] args) {
        /*
         * 模版方法模式：业务流程固定，执行方法负责数据校验、结果封装返回，业务实现放在实现抽象模板方法的子类中。
         * 策略模式：将每一种算法封装成一种实现，可以根据实际情况选择不同的算法策略
         *
         * 该例子是 策略模式和模板方法模式的结合
         *
         */
        IStrategy strategy1 = new StrategyImplOne();
        strategy1.operate();
        IStrategy strategy2 = new StrategyImplTwo();
        strategy2.operate();
    }

}
