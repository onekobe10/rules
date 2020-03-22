package com.gankki.demo.optimization.design.decorator.origin;
/**
 *
 * @author liuhao
 * @date 2020/3/22
 */
public class Test {

    public static void main( String[] args )
    {
        IDecorator decorator = new Decorator();
        IDecorator curtainDecorator = new CurtainDecorator(decorator);
        curtainDecorator.decorate();

    }

}
