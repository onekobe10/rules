package com.gankki.demo.test.lambda;

import java.util.*;
import java.util.function.Supplier;

/**
 * @author liuhao
 * @desc
 * @createDate 2019/7/26
 */
public class SupplierTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int s = 2;
        list.forEach(i -> {
            if (Objects.equals(s, i)) {
				return;
            }
			System.out.println(i);
        });
    }

}
