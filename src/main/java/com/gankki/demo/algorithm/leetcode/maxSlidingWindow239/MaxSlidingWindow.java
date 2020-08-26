package com.gankki.demo.algorithm.leetcode.maxSlidingWindow239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 *
 * @author liuhao
 * @date 2020/8/26
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> qeque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!qeque.isEmpty() && qeque.peekFirst() <= i - k) {
                qeque.pollFirst();
            }
            while (!qeque.isEmpty() && nums[qeque.peekLast()] < nums[i]) {
                qeque.pollLast();
            }
            qeque.addLast(i);
            if (i >= k - 1) {
                res[index++] = nums[qeque.peekFirst()];
            }
        }
        return res;
    }

}
