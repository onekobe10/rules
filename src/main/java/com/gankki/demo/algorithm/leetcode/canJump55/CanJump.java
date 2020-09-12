package com.gankki.demo.algorithm.leetcode.canJump55;

/**
 *  跳跃游戏
 * @author liuhao
 * @date 2020/9/7 
 */
public class CanJump {

    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        int canReachable = nums.length - 1;
        for (int i = canReachable; i >= 0; i--) {
            if (nums[i] + i >= canReachable) {
                canReachable = i;
            }
        }

        return canReachable == 0;
    }


}
