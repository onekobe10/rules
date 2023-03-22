package com.gankki.demo.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

        Integer i = 0;
        i =  1 + 2;
        System.out.println(i);
        Map<Integer, Integer> map = new HashMap<>(200);
        map.put(1, 1);

        System.out.println(tableSizeFor(300));
        System.out.println(300 << 1);
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
