package com.gankki.demo.algorithm.leetcode.uniquePaths62;

/**
 * 不同路径
 *
 * @author liuhao
 * @date 2020/9/22
 */
public class UniquePaths {

    public static void main(String[] args) {

    }

    /**
     * 2020/9/22 22:43 O(m*n) O(m∗n) 空间、时间复杂度都为 m*n
     */
    public int uniquePaths1(int m, int n) {
        int[][] mn = new int[m][n];
        for (int i = 0; i < m ; i++) {
            mn[i][0] = 1;
        }
        for (int i = 0; i < n ; i++) {
            mn[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                mn[i][j] = mn[i - 1][j] + mn[i][j - 1];
            }
        }
        return mn[m - 1][n - 1];
    }

}
