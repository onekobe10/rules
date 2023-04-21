package com.gankki.demo.test.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * stream min 测试
 *
 * @version 1.0
 * @author liuhao
 * @date 2023/4/21 11:58
 */
public class minTest {

    public static void main(String[] args) {
        Min min1 = new Min();
        min1.setPriority(1);
        min1.setMdcNo("A");
        min1.setFirst(false);

        Min min2 = new Min();
        min2.setPriority(2);
        min2.setMdcNo("B");
        min2.setFirst(false);

        Min min3 = new Min();
        min3.setPriority(0);
        min3.setMdcNo("C");
        min3.setFirst(false);

        List<Min> minList = new ArrayList<>();
        minList.add(min1);
        minList.add(min2);
        minList.add(min3);

        // min 使用 函数式接口，负值为小的一个，想等就取 o1
        System.out.println(minList.stream().min((o1, o2) -> {
            return o2.priority - o1.priority;
        }).get());

        System.out.println(minList.stream().min((o1, o2) -> {
            return o1.priority - o2.priority;
        }).get());

    }

    @Data
    public static class Min {
        private Integer priority;

        private String mdcNo;

        private Boolean first;
    }


}

