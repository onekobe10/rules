package com.gankki.demo.test.bigdecimal;

import java.math.BigDecimal;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/28
 */
public class Test3 {


    public static void main(String[] args){
        BigDecimal bigDecimal = new BigDecimal(1.001).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal.toPlainString());
    }

}
