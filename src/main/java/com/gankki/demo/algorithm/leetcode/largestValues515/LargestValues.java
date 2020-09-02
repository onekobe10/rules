package com.gankki.demo.algorithm.leetcode.largestValues515;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 *
 * @author liuhao
 * @date 2020/9/2
 */
public class LargestValues {

    public static void main(String[] args) {

    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        largest(1, result, root);
        return result;
    }

    /**
     * 2020/9/3 0:12 O(n) O(n)
     */
    private void largest(int level, List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (result.size() < level) {
            result.add(val);
        }
        result.set(level - 1, Math.max(result.get(level - 1), val));
        largest(level + 1, result, root.left);
        largest(level + 1, result, root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
