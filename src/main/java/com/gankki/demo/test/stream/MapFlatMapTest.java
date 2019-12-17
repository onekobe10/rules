package com.gankki.demo.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author liuhao
 * @date 2019/12/17
 */
public class MapFlatMapTest {


    public static void main(String[] args){
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrsMap = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());

            /*
            在执行map操作以后，我们得到是一个包含多个字符串（构成一个字符串的字符数组）的流，此时执行distinct操作是基于在这些字符串数组之间的对比，所以达不到我们希望的目的，此时的输出为：
            [j, a, v, a, 8]
            [i, s]
            [e, a, s, y]
            [t, o]
            [u, s, e]
                    */
        List<String> distinctStrsFlatMap = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());

       /*
       结果正确
        flatMap将由map映射得到的Stream<String[]>，转换成由各个字符串数组映射成的流Stream<String>，再将这些小的流扁平化成为一个由所有字符串构成的大流Steam<String>，从而能够达到我们的目的。
        */
    }

}
