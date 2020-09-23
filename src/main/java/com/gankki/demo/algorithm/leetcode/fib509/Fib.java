package com.gankki.demo.algorithm.leetcode.fib509;

/**
 * 斐波那契数列
 * @author liuhao
 * @date 2020/9/22
 */
public class Fib {

    public static void main(String[] args) {

    }

    /**
     * 2020/9/22
     * 指数级的时间复杂度：O(2^n)
     * 空间复杂度：O(n)：在堆栈中我们需要与 N 成正比的空间大小。该堆栈跟踪 fib(N) 的函数调用，随着堆栈的不断增长如果没有足够的内存则会导致 StackOverflowError。
     */
    public int fib1(int n) {
        if (n <= 1) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 2020/9/22 O(2^n) O(2^n) 三元运算符，更简洁的写法
     */
    public int fib2(int n) {
        return n <= 1 ? n : fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 2020/9/22 0:52 增加缓存，记忆化搜索 记忆化自顶而下 O(n) O(n)
     */
    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        Integer[] memo = new Integer[n + 1];// 为什么这里要使用对象类型
        memo[0] = 0;
        memo[1] = 1;
        return fib3Sub(n, memo);
    }
    private int fib3Sub(int n, Integer[] memo) {
        if (memo[n] != null) {// 原因：由于memo(0) = 0，因此不能使用 != 0 判断，否则数组下标会穿透到负数
            return memo[n];
        }
        memo[n] = fib3Sub(n - 1, memo) + fib3Sub(n - 2, memo);
        return memo[n];
    }

    /**
     * 2020/9/22 0:52 Bottom Up 自底向上迭代 O(n) O(1)
     */
    public int fib4(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1,c;
        for (int i = 2; i <= n; i++) {
            c = b;
            b = a + b;
            a = c;
        }
        return b;
    }

}
