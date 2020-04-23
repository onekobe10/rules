package com.gankki.demo.gankki.bigdecimaltest;

import java.math.BigDecimal;

/**
 * BigDecimal Test
 * @author liuhao
 * @date 2020/4/23
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a1 = new BigDecimal("1");
        // 小数位数递增
        for (int i = 0; i < 20; i++) {
            a1 = a1.multiply(new BigDecimal("0.1"));
            System.out.println("----------------------" + (i + 1) + "位小数时的输出结果-------------------------");
            System.out.println("doubleValue方法显示数值：                         " + a1.doubleValue());
            System.out.println("toString方法显示数值：                                 " + a1.toString());
            System.out.println("toPlainString方法显示数值：                    " + a1.toPlainString());
        }
        System.out.println("\n\n");
        a1 = new BigDecimal("1");
        // 整数位数递增
        for (int i = 1; i < 20; i++) {
            a1 = a1.multiply(new BigDecimal("10"));
            System.out.println("----------------------" + (i + 1) + "位整数时的输出结果-------------------------");
            System.out.println("doubleValue方法显示数值：                         " + a1.doubleValue());
            System.out.println("toString方法显示数值：                                 " + a1.toString());
            System.out.println("toPlainString方法显示数值：                    " + a1.toPlainString());
        }
        System.out.println("\n\n");
        // 始终两位小数位，整数位递增
        a1 = new BigDecimal("1");
        for (int i = 1; i < 30; i++) {
            a1 = a1.setScale(0, BigDecimal.ROUND_DOWN).multiply(new BigDecimal("10.11"));
            System.out.println("----------------------" + i + "位整数,2位小数时的输出结果-------------------------");
            System.out.println("doubleValue方法显示数值：                         " + a1.doubleValue());
            System.out.println("toString方法显示数值：                                 " + a1.toString());
            System.out.println("toPlainString方法显示数值：                    " + a1.toPlainString());
        }
        System.out.println("\n\n");
        // 小数位、整数位同时递增
        a1 = new BigDecimal("1");
        for (int i = 1; i < 30; i++) {
            if (i % 2 == 0) {
                a1 = a1.multiply(new BigDecimal("10"));
            } else {
                a1 = a1.multiply(new BigDecimal("10.1"));
            }
            System.out.println(
                    "----------------------" + (i + 1) + "位整数," + ((i + 1) / 2) + "位小数时的输出结果-------------------------");
            System.out.println("doubleValue方法显示数值：                         " + a1.doubleValue());
            System.out.println("toString方法显示数值：                                 " + a1.toString());
            System.out.println("toPlainString方法显示数值：                    " + a1.toPlainString());
        }
    }

}
