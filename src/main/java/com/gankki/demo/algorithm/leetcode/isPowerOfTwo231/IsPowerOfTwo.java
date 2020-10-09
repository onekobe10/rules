package com.gankki.demo.algorithm.leetcode.isPowerOfTwo231;

public class IsPowerOfTwo {

    public static void main(String[] args) {

    }


    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
