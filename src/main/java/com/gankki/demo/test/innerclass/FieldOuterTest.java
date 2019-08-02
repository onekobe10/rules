package com.gankki.demo.test.innerclass;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/1
 */
public class FieldOuterTest {
    private int a = 100;

    public class Inner {
        public void innerMethod(){
            System.out.println("outer a " +a);
            FieldOuterTest.this.action();
        }
    }

    private void action(){
        System.out.println("action");
    }

    public void test(){
        Inner inner = new Inner();
        inner.innerMethod();
    }

}
