package com.gankki.demo.designpattern.singleton;

/**
 * 枚举的实现
 * 枚举的实现可以保证即使在反序列化也是单例的
 * <p>
 * 最佳的单例实现模式就是枚举模式。利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题
 *
 * @author liuhao
 * @date 2020/12/1
 */
public class UserEnum {
    private UserEnum() {
    }

    enum SingletonEnum {
        INSTANCE;

        private UserEnum user;

        SingletonEnum() {
            user = new UserEnum();
        }

        public UserEnum getInstance() {
            return user;
        }
    }

    public static UserEnum getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

}
