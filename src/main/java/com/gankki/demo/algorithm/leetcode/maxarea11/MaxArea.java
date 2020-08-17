package com.gankki.demo.algorithm.leetcode.maxarea11;

/**
 *
 * @author liuhao
 * @date 2020/8/16
 */
public class MaxArea {

    public static void main(String[] args) {

    }

    /**
     * 2020/8/16 14:51 O(n) O(1)
     */
    public int maxArea1(int[] height) {
        int ant = 0, d = height.length - 1;
        for (int i = 0; i < height.length; i++ ) {
            int area = Math.min(height[i], height[height[d]]) * (d - 1);
            ant = Math.max(area, ant);
            if (height[i] < height[d]) {
                i++;
            } else {
                d--;
            }
        }
        return ant;
    }

    /**
     * 2020/8/16 15:21 O(n) O(1)
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, minHeight * (j - i + 1));
        }
        return max;
    }

}
