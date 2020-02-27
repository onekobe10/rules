package com.gankki.demo.test.intdivide;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author liuhao
 * @date 2020/2/27 
 */
public class IntegerDivide {

    public static void test(double d){
        System.out.println(d);
    }

    /**
     * 整数相除会损失精度，除非使用浮点型数据类型
     * @param args
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        double f =3.2d;
        test(a/2);
        float c = a/b;
        //此时c的值丢失精度
        System.out.println(c);

        double e = f / 2;
        System.out.println(e);

        System.out.println((int)Math.ceil(e));
        System.out.println((int)Math.ceil(b));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        int listSize = list.size();
        // 'listSize * 4 / 3': integer division in floating-point context
        Map<Long, BigDecimal> userMap = new HashMap<>((int) Math.ceil(listSize * 4.0 / 3));
    }

}
