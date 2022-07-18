package com.gankki.demo.algorithm.classify.array;

public class removeElement27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0 , fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            ++fast;
        }
        return slow;
    }


}
