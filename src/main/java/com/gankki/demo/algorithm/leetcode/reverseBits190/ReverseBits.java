package com.gankki.demo.algorithm.leetcode.reverseBits190;


public class ReverseBits {

    public static void main(String[] args) {

    }

    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
