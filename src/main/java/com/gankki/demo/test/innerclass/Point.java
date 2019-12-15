package com.gankki.demo.test.innerclass;

import lombok.Data;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/1
 */
@Data
public class Point {
    private Integer a;
    private Integer b;

    public Point(){

    }

    public Point(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public double distance() {
        return 1.2d;
    }
}
