package com.gankki.demo.algorithm.leetcode.preorderTraversal144;

import com.gankki.demo.algorithm.leetcode.inorderTraversal94.InorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历
 * @author liuhao
 * @date 2020/8/26
 */
public class PreorderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 2020/8/26 21:09 O(n) O(n)
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        des(list, root);
        return list;
    }

    private void des(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        des(list, root.left);
        des(list, root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
