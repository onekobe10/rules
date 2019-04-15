package com.gankki.demo.note150.abstractAndInterface;

public interface InterfaceTest {

    // 接口中不能定义构造器
    /*
        public InterfaceTest(){

        }
    */

    // 接口中定义的属性为静态常量
    public static final String testAttr = "111";
    // 接口中定义的静态常量可以不写修饰符
    String testAttr2 = "111";

    // 默认方法可以有实现，必须default访问修饰物修饰
    default void testMethd() {
        System.out.println("测试jdk1.8接口新特性");
    }

    // 静态方法可以有实现
    static void testStaticMethod() {
        System.out.println("测试jdk1.8接口静态新特性");
    }

    // jdk1.8之前的抽象方法
    void testBeforeMethod();

    public static void main(String[] args) {
        /*
         * 静态方法和默认方法是jdk1.8的新特性，这两种方法在接口中可以有实现
         * 其他的方法都是抽象方法，
         * 定义的属性都为静态常量
         * 只有默认方法为default的访问修饰符，其他的属性和方法都是public，可以不写
         * 接口中不能定义构造器
         * */
    }
}
