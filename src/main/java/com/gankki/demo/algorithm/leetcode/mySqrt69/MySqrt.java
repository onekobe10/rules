package com.gankki.demo.algorithm.leetcode.mySqrt69;

/**
 * 平方根
 *
 * @author liuhao
 * @date 2020/9/6
 */
public class MySqrt {

    public static void main(String[] args) {
        mySqrt2(5);
    }

    // Java 二分查找的模板
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 2020/9/6 22:54 二分法 O(logn) O(1)
     */
    public static int mySqrt1(int x) {
        int left = 0, right = x, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long)mid * mid <= x) {// 平方根可能没有正好平方的数据、没有 long 转换会超出时间限制
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    /**
     * 2020/9/6 22:54 二分法错误示范 O(logn) O(1)
     */
    public static int mySqrt2(int x) {
        int left = 0, right = x, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid == x) {// 没有考虑到不能开平方的情况
                result = mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static int mySqrt3(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2, right = x / 2, result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid <= x) {// 平方根可能没有正好平方的数据
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

}

