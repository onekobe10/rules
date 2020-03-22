package com.gankki.demo.optimization.design.singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * 懒汉模式 内部类实现
 * 懒汉实现的原理是：懒加载，内部类只有在外部类被调用的时候才会被加载到 JVM 中
 * @author liuhao
 * @date 2020/3/20
 */
public final class Singleton2 {
    // list属性
    public List<String> list;
    //构造函数
    private Singleton2() {
        list = new ArrayList<>();
    }

    // 内部类实现
    public static class InnerSingleton {
        private static Singleton2 instance=new Singleton2();//自行创建实例
    }

    public static Singleton2 getInstance() {
        return InnerSingleton.instance;// 返回内部类中的静态变量
    }
}