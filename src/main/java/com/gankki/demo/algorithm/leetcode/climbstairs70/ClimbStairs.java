package com.gankki.demo.algorithm.leetcode.climbstairs70;

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
     * 2020/8/16 15:46 O(n) O(1) 从头到尾遍历实现
     */
    public int climbStairs1(int n) {
        if (n <= 2) {
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

    /**
     * 2020/8/30 16:54 O(2^n) O(1) 头递归，从高到低，没有增加缓存，不能复用
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    /**
     * 2020/8/30 17:18 O(n) O(1) 尾递归，从低到高，不用复用
     */
    public int climbStairs3(int n) {
        return climbStairs3Inner(n ,1, 1);
    }

    public int climbStairs3Inner(int n, int a, int b) {
        if (n <= 1) {
            return b;
        }
        return climbStairs3Inner(--n, b, a + b);
    }

}
