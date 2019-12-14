package com.gankki.demo.test.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author liuhao
 */
public class ParallelStream {

    /**
     * ArrayList 线程不安全
     * @param args
     */
    public static void main(String[] args){
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            integerList.add(i);
        }
        List<Integer> parallelList = Collections.synchronizedList(new ArrayList<>());
        //List<Integer> parallelList = new ArrayList<>();
        integerList.stream()
                .parallel()
                .filter(i -> i % 2 == 1)
                .forEach(parallelList::add);
        System.out.println(parallelList.size());
    }

}
