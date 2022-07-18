package com.gankki.demo.algorithm.classify.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 */
public class inorderTraversal94 {

    public List<Integer> inorderTraversal(maxDepth104.TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
}
