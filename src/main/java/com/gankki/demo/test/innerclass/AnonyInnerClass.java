package com.gankki.demo.test.innerclass;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/1
 */
public class AnonyInnerClass {

    public void test(int x, int y){
        String a1 = "ssss";
        FieldOuterTest s1 = new FieldOuterTest();

        Point p = new Point(3,4){
            @Override
            public double distance() {
                s1.setA(1);
                System.out.println("a1............." + a1);
                System.out.println(x + "....." + y);
                System.out.println(this.getA() + "......" + this.getB());
                return 1.2d;
            }
        };
        System.out.println(p.distance());
        System.out.println(s1.getA());
    }

    public static void main(String[] args){
        AnonyInnerClass a1 = new AnonyInnerClass();
        a1.test(1, 2);
    }

}
