package com.gankki.demo.gankki.finaltest;

/**
 * final test
 * @author liuhao
 * @date 2020/4/18
 */
public class FinalTest {


    public static void main(String[] args){
        test1("liuhao");
    }

    /**
     * 修饰方法参数，在防范调用被赋值之后在方法中执行不可变
     * @param arg1
     */
    public static void test1(final String arg1) {
        System.out.println(arg1);
    }
}
