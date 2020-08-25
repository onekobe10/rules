package com.gankki.demo.algorithm.leetcode.twosum1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author liuhao
 * @date 2020/8/12
 */
public class TwoSumTest {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 链接：https://leetcode-cn.com/problems/two-sum
     * <p>
     * <p>
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 2020/8/12 21:30 O(n*n) O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] targetIndex = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int temp = nums[i] + nums[j];
                    if (temp == target) {
                        targetIndex[0] = i;
                        targetIndex[1] = j;
                        break;
                    }
                }
            }
        }
        return targetIndex;
    }

    /**
     * 2020/8/12 21:46 O(n*n) O(1)
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (target == nums[i] + nums[j]) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * 2020/8/12 22:21 O(n) O(n)
     * <p>
     * 1. 保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
     * 2. HashMap<int, int> objectObjectHashMap = new HashMap<>();
     * 错误，泛型不能为基本数据类型
     */
    public int[] twoSum3(int[] nums, int target) {
        // O(n)
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            tempMap.put(nums[i], i);
        }
        // O(1)
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (tempMap.containsKey(temp) && tempMap.get(temp) != i) {
                return new int[]{i, tempMap.get(temp)};
            }
        }
        return null;
    }

    /**
     * 2020/8/25 16:06 O(n) O(n)
     */
    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (tempMap.containsKey(temp)) {
                return new int[]{i, tempMap.get(temp)};
            } else {
                tempMap.put(nums[i], i);
            }
        }
        return null;
    }

}
