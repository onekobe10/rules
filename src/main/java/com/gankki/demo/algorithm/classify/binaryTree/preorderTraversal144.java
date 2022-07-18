package com.gankki.demo.algorithm.classify.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class preorderTraversal144 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(maxDepth104.TreeNode root) {
        traverse(root);
        return res;
    }

    public void traverse(maxDepth104.TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public List<Integer> preorderTraversal2(maxDepth104.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal2(root.left));
        res.addAll(preorderTraversal2(root.right));
        return res;
    }


}
