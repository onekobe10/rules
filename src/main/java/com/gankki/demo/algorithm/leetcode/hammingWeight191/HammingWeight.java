package com.gankki.demo.algorithm.leetcode.hammingWeight191;


public class HammingWeight {

    public static void main(String[] args) {

    }

    public int hammingWeight1(int n) {
        int bit = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bit++;
            }
            mask <<= 1;
        }
        return bit;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
