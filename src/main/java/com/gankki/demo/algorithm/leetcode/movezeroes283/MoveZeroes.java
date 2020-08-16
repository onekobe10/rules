package com.gankki.demo.algorithm.leetcode.movezeroes283;

/**
 *
 * @author liuhao
 * @date 2020/8/15
 */
public class MoveZeroes {

    public static void main(String[] args) {

    }

    /**
     * 2020/8/15 22:58 O(n)  O(n)
     */
    public void moveZeroes1(int[] nums) {
        int head = 0;
        for (int tail = 0; tail < nums.length; tail++) {
            if (nums[tail] != 0) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
                head++;
            }
        }
    }

    /**
     * 2020/8/15 23:47 O(n)  O(1)
     */
    public void moveZeroes2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 2020/8/16 0:05  O(n)  O(1)
     */
    public void moveZeroes3(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp != 0) {
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    /**
     * 2020/8/16 0:27 O(n)  O(1)
     */
    public void moveZeroes4(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes5(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
