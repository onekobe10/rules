package com.gankki.demo.designpattern.singleton;

/**
 * 静态内部类实现
 * 通过静态内部类的方式实现单例模式是线程安全的，
 * 同时静态内部类不会在Singleton类加载时就加载，
 * 而是在调用getInstance()方法时才进行加载，达到了懒加载的效果
 * @author liuhao
 * @date 2020/12/1
 */
public class StaticInnerSingleton {
    private static class SingletonHolder {
        private static StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    private StaticInnerSingleton() {

    }

    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
