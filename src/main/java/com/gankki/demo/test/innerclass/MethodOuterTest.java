package com.gankki.demo.test.innerclass;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/1
 */
public class MethodOuterTest {

    private int a = 100;

    public void test(final int param){
        final String str = "hello";
        class Inner {
            public void innerMethod(){
                System.out.println("outer a " +a);
                System.out.println("param " +param);
                System.out.println("local var " +str);
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

}
