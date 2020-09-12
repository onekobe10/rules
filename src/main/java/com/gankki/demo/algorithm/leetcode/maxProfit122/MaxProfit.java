package com.gankki.demo.algorithm.leetcode.maxProfit122;

/**
 * 买卖股票的最佳时机 II
 * @author liuhao
 * @date 2020/9/7 
 */
public class MaxProfit {

    public static void main(String[] args) {

    }

    /**
     * 2020/9/10 23:34 贪心算法 O(n) O(1)
     * 多次买卖一支股票：可以在同一天先卖出股票，再买入。
     */
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i++] > prices[i]) {
                total += prices[i++] - prices[i];
            }
        }
        return total;
    }

}
