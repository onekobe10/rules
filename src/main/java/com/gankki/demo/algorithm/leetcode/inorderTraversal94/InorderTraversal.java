package com.gankki.demo.algorithm.leetcode.inorderTraversal94;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 * @author liuhao
 * @date 2020/8/25
 */
public class InorderTraversal {

    public static void main(String[] args) {

    }

    /**
     * 2020/8/26 18:49 O(n) O(n)
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        des(list, root);
        return list;
    }

    private void des(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        des(list, root.left);
        list.add(root.val);
        des(list, root.right);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

}
