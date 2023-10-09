package com.gankki.demo.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日常测试
 *
 * @auth liuhao
 * @version 1.0
 * @date 2023/3/20 14:31
 */
public class DailyTest {

    public static void main(String[] args) throws Exception {
        /* date 的 before after

        Date curr = new Date();
        Date before = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-02-02 00:00:00");
        System.out.println(before.before(curr));

        */

        /* HashMap 扩容机制
        Integer i = 0;
        i =  1 + 2;
        System.out.println(i);
        Map<Integer, Integer> map = new HashMap<>(200);
        map.put(1, 1);

        System.out.println(tableSizeFor(300));
        System.out.println(300 << 1);
        */

        /* 对象强转
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("1");
        Object obj = (Object) set;
        for (String s : (Set<String>) obj) {
            System.out.println(s);
        }
        */

        /* 除法运算
        String div4Str = "0.00";
        System.out.println(handleCalFeeRatePer(div4Str));
        */

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(3);
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(String.format("|", hashSet));
    }

    public static String div4Str(double v1, double v2) {// 除法
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP).toPlainString();
    }

    /**
     * 小数转百分比
     *
     * @param feeRate
     * @return
     */
    private static String handleCalFeeRatePer(String feeRate) {
        return StringUtils.isEmpty(feeRate) ? null : mul2Str(Double.parseDouble(feeRate), 100) + "%";
    }

    public static String mul2Str(double v1, double v2) {// 乘法
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }


    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
