package com.gankki.demo.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/9/3
 */
public class StreamPeekTest {

    /**
     * 可以使用 peek 方法来遍历流中的每个元素，peek方法还返回由此元素组成的流
     * @param args
     */
    public static void main(String[] args){
        List<String> listq = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> list2 = listq.stream().peek(System.out::print).filter(t -> "1".equals(t)).collect(Collectors.toList());

        System.out.println();

        list2.forEach(System.out::print);

        List<String> listw = Arrays.asList("1", "3", "2", "4", "5", "6");
        List<String> list3 = listw.parallelStream().peek(System.out::print).collect(Collectors.toList());

        System.out.println();

        list3.forEach(System.out::print);

    }
    
}
