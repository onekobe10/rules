package com.gankki.demo.algorithm.classify.binaryTree;

public class diameterOfBinaryTree543 {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(maxDepth104.TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    public void traverse (maxDepth104.TreeNode root) {
        if (root == null) {
            return;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    public int maxDepth(maxDepth104.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree2(maxDepth104.TreeNode root) {
        maxDepth2(root);
        return maxDiameter;
    }

    public int maxDepth2 (maxDepth104.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(myDiameter, maxDiameter);
        return Math.max(leftMax, rightMax) + 1;
    }
}
