package com.gankki.demo.test.innerclass;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/1
 */
public class AnonyInnerClass {

    public void test(final int x, final int y){
        final String a = "ssss";
        FieldOuterTest s1 = new FieldOuterTest();
        Point p = new Point(2,3){

            @Override
            public double distance(Point point) {
                System.out.println("b............." + a);
                System.out.println(x + "....." + y);
                s1.setA(1);
                return 1.2d;
            }
        };
        System.out.println(p.distance(new Point(x, y)));
        System.out.println(s1.getA());
    }


    public static void main(String[] args){
        AnonyInnerClass a1 = new AnonyInnerClass();
        a1.test(1, 2);
    }

}
