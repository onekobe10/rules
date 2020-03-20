package com.gankki.demo.optimization.design;

/**
 * 枚举内布类实现懒汉式
 * 最安全的方式，反射、序列化都是单例，强烈推荐！！！
 * @author liuhao
 * @date 2020/3/20
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    // 私有构造函数
    private Singleton3(){
    }

    public static Singleton3 getInstance(){
        return Singleton.SINLETON.getInstance();
    }

    private enum Singleton {
        SINLETON;

        private Singleton3 singleton;

        // JVM 保证这个方法只调用一次
        Singleton() {
            singleton = new Singleton3();
        }

        public Singleton3 getInstance() {
            return singleton;
        }
    }

}
