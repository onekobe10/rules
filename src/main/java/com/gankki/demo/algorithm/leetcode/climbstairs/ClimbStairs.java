package com.gankki.demo.algorithm.leetcode.climbstairs;

/**
 *
 * @author liuhao
 * @date 2020/8/16
 */
public class ClimbStairs {

    /**
     * 找最近重复子问题
     *  if else for loop recursion
     *
     * @author liuhao
     * @date 2020/8/16
     */
    public static void main(String[] args) {

    }

    /**
     * 2020/8/16 15:46
     */
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int temp = 0, a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

}
