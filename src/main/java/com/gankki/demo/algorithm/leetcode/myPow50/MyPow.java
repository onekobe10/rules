package com.gankki.demo.algorithm.leetcode.myPow50;

/**
 * Pow(x, n)
 *
 * @author liuhao
 * @date 2020/8/30
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow2(2, -2147483648));
    }

    /**
     * 2020/9/1 23:20 快速幂+递归 O(logn) O(logn)
     * 底一定为 2 * 1，如果是奇数在最上层 * x
     */
    public  double myPow1(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, n);
    }

    public double quickMul(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    static double quickMul2(double x, long n) {
        double result = 1;
        double var = x;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= var;
            }
            var *= var;
            n /= 2;
        }
        return result;
    }

    public static double myPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(1, N) : 1.0 / quickMul2(2, -N);
    }

}
