package com.gankki.demo.algorithm.classify.binaryTree;

/**
 * 二叉树中的最大路径和
 *
 */
public class maxPathSum124 {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(maxDepth104.TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    public int maxSum(maxDepth104.TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 只要大于 0的才会记入，否则就是加上就是越来越小了。
        int leftSum = Math.max(0, maxSum(root.left));
        int rightSum = Math.max(0, maxSum(root.right));
        int mySum = leftSum + rightSum + root.val;
        maxSum = Math.max(mySum, maxSum);
        return Math.max(leftSum, rightSum) + root.val;
    }

}
