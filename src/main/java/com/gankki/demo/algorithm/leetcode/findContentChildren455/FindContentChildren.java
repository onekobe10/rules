package com.gankki.demo.algorithm.leetcode.findContentChildren455;

import java.util.Arrays;

/**
 * 分发饼干
 * @author liuhao
 * @date 2020/9/10 
 */
public class FindContentChildren {

    public static void main(String[] args) {

    }

    /**
     * 2020/9/10 23:09 贪心算法 O(n) O(1)
     * 如果贪心算法能实现，贪心算法一般就是最优解
     */
    public int findContentChildren1(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        // 无序变有序
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

}
