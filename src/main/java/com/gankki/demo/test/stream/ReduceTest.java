package com.gankki.demo.test.stream;

import java.util.stream.Stream;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/9/2
 */
public class ReduceTest {

    /**
     * Steam 的 累计功能
     * @param args
     */
    public static void main(String[] args){
        Integer reduce = Stream.of(1, 2, 3, 4, 5).reduce(1, (count, item) -> {
            System.out.print("count:" + count + "       ");
            System.out.print("item: " + item);
            System.out.println("");
            return count + item;
        });

        System.out.println("0.................:" + reduce);
    }
    
}
