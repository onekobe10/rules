package com.gankki.demo.test.finallly;

import java.util.Objects;

public class TestFinally {

    public static void main(String[] args) {
        test("1");
    }

    public static void test(String a) {
        try {
            if (Objects.equals(a, "1")) {
                System.out.println("111111");
                return;
            }
            System.out.println("2222");
        } finally {
            System.out.println("33333");
        }
    }
}
