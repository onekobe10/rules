package com.gankki.demo.test.stream.jiufu;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * match
 *
 * @author liuhao
 * @date 2019/12/27
 */
public class Test4 {


    public static void main(String[] args) {
        Stream<Integer> s = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        // s中是否所有元素都大于0
        boolean b = s.allMatch(i -> i > 0);
        // true
        System.out.println(b);

        // 只要有一个元素大于6就返回true
        s = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean b2 = s.anyMatch(i -> i > 6);
        //true
        System.out.println(b2);

        // 没有一个元素满足小于1
        s = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        boolean b3 = s.noneMatch(i -> i < 0);
        //true
        System.out.println(b3);
    }

}
