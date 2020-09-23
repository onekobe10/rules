package com.gankki.demo.algorithm.leetcode.uniquePathsWithObstacles63;

/**
 * 不同路径 II
 *
 * @author liuhao
 * @date 2020/9/22
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {

    }

    /**
     * 2020/9/23 16:08 O(m*n) O(n)
     * 滚动数组思想、二维数组降维
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] roll = new int[n];
        roll[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    roll[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j] == 0) {// 等同于 if (j - 1 >= 0)
                    roll[j] += roll[j - 1];// 滚动数组
                }
            }
        }
        return roll[n - 1];
    }

}
