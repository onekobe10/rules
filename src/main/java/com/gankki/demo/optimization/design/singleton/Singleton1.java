package com.gankki.demo.optimization.design.singleton;


import java.util.ArrayList;
import java.util.List;

/**
 * 懒汉模式 + synchronized同步锁 + double-check + volatile
 *  synchronized同步锁 Synchronized 只能保证可见性、原子性，无法保证执行的顺序。
 *  doublue-check: 存在多个线程进入第一个if，等待锁的情况，锁的内部再加一个判断，可以真正实现单例
 *  volatile：如果此时有其他成员属性，可能会发生重排序导致异常，volatile 关键字可以保证线程间变量的可见性，
 *      除此之外，volatile 在 JDK1.5 之后还有一个作用就是阻止局部重排序的发生，也就是说，volatile 变量的操作指令都不会被重排序。
 * @author liuhao
 * @date 2020/3/20
 */
public final class Singleton1 {
    //不实例化
    private volatile static Singleton1 instance= null;
    //list属性
    public List<String> list;

    //构造函数
    private Singleton1(){
        list = new ArrayList<>();
    }
    public static Singleton1 getInstance(){//加同步锁，通过该函数向整个系统提供实例
        if(null == instance){//第一次判断，当instance为null时，则实例化对象，否则直接返回对象
            synchronized (Singleton1.class){//同步锁
                if(null == instance){//第二次判断
                    instance = new Singleton1();//实例化对象
                }
            }
        }
        return instance;//返回已存在的对象
    }
}
