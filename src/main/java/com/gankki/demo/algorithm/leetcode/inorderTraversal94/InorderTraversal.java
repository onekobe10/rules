package com.gankki.demo.algorithm.leetcode.inorderTraversal94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * @author liuhao
 * @date 2020/8/25
 */
public class InorderTraversal {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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

    /**
     * 2020/8/26 18:49 O(n) O(n) 栈实现的中序遍历
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

}
