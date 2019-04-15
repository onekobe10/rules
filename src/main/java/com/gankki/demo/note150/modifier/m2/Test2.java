package com.gankki.demo.note150.modifier.m2;

import com.gankki.demo.note150.modifier.m1.Test1;

public class Test2 extends Test1 {

    @Override
    public void test() {
        System.out.println("在Test2中重写Test1的方法");
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        // 不同包下不能访问protected方法
        //test1.test();
    }
}
