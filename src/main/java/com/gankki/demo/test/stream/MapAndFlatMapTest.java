package com.gankki.demo.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/9/2
 */
public class MapAndFlatMapTest {

    /**
     * Stream 的映射功能
     * map 处理的是一维集合（数组）
     * flatMap 可以将二维数组中的每个元素遍历出来组成一个新的一维（数组）
     * map只是一维 1对1 的映射
     * 而flatMap可以将一个2维的集合映射成一个一维,相当于映射的深度比map深了一层 ,
     * @param args
     */
    public static void main(String[] args){
        String[] words1 = new String[]{"Hello","World"};
        List<String[]> a1 = Arrays.stream(words1)
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        // 返回一个包含两个String[]的list
        a1.forEach(System.out::println);

        System.out.println("...................1.....................");

        String[] words2 = new String[]{"Hello","World"};
        List<String> a2 = Arrays.stream(words2)
                // 必须将元素分割成个体才能去重
                .map(word2 -> word2.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        a2.forEach(System.out::print);

        System.out.println("");
        System.out.println("..................2......................");

        String[] words3 = new String[]{"Hello","World"};
        Stream.of(words3).map(i -> i.split("")).flatMap(Stream::of).collect(toList()).forEach(System.out::print);

        System.out.println("");
        System.out.println("..................3......................");

        List<String> words4 = new ArrayList<>();
        words4.add("Hello");
        words4.add("World");
        List<String[]> a4 = words4.parallelStream().map(word -> word.split("")).distinct().collect(toList());
        a4.forEach(System.out::print);

        System.out.println("");
        System.out.println("..................4......................");

        List<String> a5 = words4.parallelStream().flatMap(Stream::of).distinct().collect(toList());
        a5.forEach(System.out::println);

        System.out.println("");

    }

}
