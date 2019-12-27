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
        distinctStrsMap.forEach(t -> {
            System.out.println(Arrays.toString(t));
        });

        System.out.println("");
        List<String> distinctStrsFlatMap = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        distinctStrsFlatMap.forEach(System.out::println);
    }

}
