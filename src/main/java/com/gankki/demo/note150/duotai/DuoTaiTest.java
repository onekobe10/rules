package com.gankki.demo.note150.duotai;

public class DuoTaiTest {
    public String test = "test";

    public void testMethod() {
        System.out.println("DuoTaiTest的测试方法");
    }

    public static void testStaticMethod() {
        System.out.println("DuoTaiTest的静态测试方法");
    }

    public static void testStaticMethod(String str) {
        System.out.println("DuoTaiTest的静态测试方法");
    }

}

class DuoTaiSonTest extends DuoTaiTest {
    public String test = "testSon";

    @Override
    public void testMethod() {
        System.out.println("DuoTaiSonTest的重写测试方法");
    }

    // @Override 静态方法是属于类对象的，不能被子类重写
    public static void testStaticMethod() {
        System.out.println("DuoTaiTest的静态重写测试方法");
    }


    public static void main(String[] args) {
        DuoTaiTest duoTaiTest = new DuoTaiSonTest();
        DuoTaiSonTest duoTaiSonTest = new DuoTaiSonTest();
        duoTaiTest.testMethod();
        System.out.println(duoTaiTest.test);
        System.out.println(duoTaiSonTest.test);
    }
}
