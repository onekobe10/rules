package com.gankki.demo.note150.anonymousinnerclassandsort;

/**
 * @author liuhao
 * @desc 匿名内部类练习
 * @createDate 2018/11/25
 */
public class AnonyInnerClass {

    public void test(String name) {
        // 接口
        AnonyInnerInterface anonyInnerInterface = new AnonyInnerInterface() {
            private String testAttr;
            String test1 = "111";

            @Override
            public String testAnony() {
                test1 = "222";
                // 引用外部方法的参数是不能修改的，外部方法的形参会通过匿名内部类的
                // 的构造器赋给匿名内部类的变量（外部方法的形参作为成员变量存在在匿名内部类中）
                // 然后在匿名内部类中的方法中通过自己的成员变量调用
                // 这样就会导致，如果在匿名内部类中修改了形参，在外部的方法中不会改变。
                // 因此默认形参是final的
                System.out.println("测试匿名内部类的方法" + name);
                return null;
            }
        };
        anonyInnerInterface.testAnony();
        System.out.println(name + "....");
    }


    public static void main(String[] args) {
        // 普通类 继承自普通类的匿名内部类没什么意义，一般是接口或者抽象类
        AnonyInnerClass anonyInnerClass = new AnonyInnerClass() {

        };
        AnonyInnerClass anonyInnerClass1 = new AnonyInnerClass();
        anonyInnerClass1.test("测试final");
        /*
         * 匿名内部类可以继承自一个普通类，一个抽象类或者一个接口
         * 原理就是继承自他们的实现类，马上创建一个实例，这样就导致匿名内部类的引用获取不到
         * 只能获取的它的一个实例，不能重复使用
         * 由于不能获取到类对象，因此匿名内部类中不能有静态的方法或者属性
         * 匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。
         * 匿名内部类没有构造方法，可以通过代码块的方式初始化匿名内部类的成员变量
         * */

    }
}

