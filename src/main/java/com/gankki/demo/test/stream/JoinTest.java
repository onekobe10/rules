package com.gankki.demo.test.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/9/2
 */
public class JoinTest {

    public static void main(String[] args){
        // 定义人名数组
        final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
        Stream<String> stream1 = Stream.of(names);
        Stream<String> stream2 = Stream.of(names);
        Stream<String> stream3 = Stream.of(names);
        // 拼接成 [x, y, z] 形式
        String result1 = stream1.collect(Collectors.joining(", ", "[", "]"));
        // 拼接成 x | y | z 形式
        String result2 = stream2.collect(Collectors.joining(" | ", "", ""));
        // 拼接成 x -> y -> z] 形式
        String result3 = stream3.collect(Collectors.joining(" -> ", "", ""));
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}
