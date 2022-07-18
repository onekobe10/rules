package com.gankki.demo.algorithm.classify.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 后序遍历
 */
public class postorderTraversal145 {

    public List<Integer> postorderTraversal(maxDepth104.TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

}
