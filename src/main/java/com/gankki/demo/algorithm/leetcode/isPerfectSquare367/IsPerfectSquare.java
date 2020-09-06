package com.gankki.demo.algorithm.leetcode.isPerfectSquare367;

/**
 * 完全平方数
 * @author liuhao
 * @date 2020/9/6
 */
public class IsPerfectSquare {

    public static void main(String[] args) {

    }

    public boolean isPerfectSquare1(int num) {
        if (num < 2) {
            return true;
        }
        int left = 2, right = num / 2;// 平方根的情况肯定出现在中位数之前，特殊情况0、1提前处理即可。
        while (left <= right) {
            int mid = (left + right) / 2;
            int temp = mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 2020/9/6 23:38 O(logn) O(1) 不转换 long 会超过 leetcode 的时间限制
     */
    public boolean isPerfectSquare2(int num) {
        long left = 0, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
