package com.gankki.demo.note150.modifier.m1;

import com.gankki.demo.note150.clone.Student;

public class Test1 {

    protected void test() {
        System.out.println("Test1的测试方法");
    }


    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();

        Student student = new Student();
        // 不能在其他包和非子类中获取protect修饰的方法或属性
        //student.clone();
    }

}
