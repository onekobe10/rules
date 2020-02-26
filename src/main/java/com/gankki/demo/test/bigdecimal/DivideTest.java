package com.gankki.demo.test.bigdecimal;

import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author liuhao
 * @date 2020/2/24
 */
public class DivideTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("45000.00");
        BigDecimal b = new BigDecimal("9500");
        BigDecimal[] c = a.divideAndRemainder(b);

        System.out.println("整数部分：" + c[0].toString() + "   小数部分：" + c[1].toString());

        BigDecimal d = a.divide(b,0,BigDecimal.ROUND_DOWN);
        System.out.println(d.toString());

        Assert.notNull(a);
    }

}
