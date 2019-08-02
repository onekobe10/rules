package com.gankki.demo.test.innerclass;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/1
 */
public class AnonyInnerClass {

    public void test(final int x, final int y){
        Point p = new Point(2,3){

            @Override
            public double distance(Point point) {
                return 1.0d;
            }
        };

        System.out.println(p.distance(new Point(x, y)));
    }

}
