package com.gankki.demo.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author liuhao
 * @date 2020/3/18
 */
public class returntest {

    /**
     * Stream 中 return 相当于 for循环中的continue
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.stream().forEach(s -> {
                    if (Objects.equals("2", s)) {
                        return;
                    }
                    System.out.println(s);
                }
        );
        list.stream().filter(s -> {
            if (Objects.equals("2", s)) {
                return true;
            }
            return false;
        });
        System.out.println(list.size());
    }

}
