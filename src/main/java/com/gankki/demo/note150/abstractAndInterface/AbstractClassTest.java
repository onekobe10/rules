package com.gankki.demo.note150.abstractAndInterface;

/**
 *@desc 抽象类测试
 *@author liuhao
 *@createDate 2018/10/18
 */
public abstract class AbstractClassTest implements InterfaceTest{


    public  AbstractClassTest(){
        super();
    }

    private  AbstractClassTest(String str){
        super();
    }


    public static void main(String[] args){
      /*
      * 抽象类中可以定义各种访问修饰符的构造器,如果不是单例不要定义private，否则所有的子类都不能调用父类的构造方法
      *
      * */
    }

}
