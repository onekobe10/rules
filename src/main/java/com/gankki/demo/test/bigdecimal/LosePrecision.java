package com.gankki.demo.test.bigdecimal;

import java.math.BigDecimal;

/**
 * 丢失精度
 * @author liuhao
 * @date 2020/3/7
 */
public class LosePrecision {

    public static void main(String[] args){
        /**
         * 浮点型在运算时会丢失精度
         * Java中float的精度为6-7位有效数字。double的精度为15-16位。
         */
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);

        /**
         * 使用 BigDecimal 必须使用字符串才有意义不会丢失精度
         * 我们一般使用BigDecimal来解决商业运算上丢失精度的问题的时候，
         * 声明BigDecimal对象的时候一定要使用它构造参数为String的类型的构造器。
         */
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.02");
        System.out.println(a.add(b));
        System.out.println(c.add(d));
    }

}
