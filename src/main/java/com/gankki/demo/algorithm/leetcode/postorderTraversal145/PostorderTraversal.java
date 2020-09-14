package com.gankki.demo.algorithm.leetcode.postorderTraversal145;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后续遍历
 * @author liuhao
 * @date 2020/9/13
 */
public class PostorderTraversal {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 2020/9/13 23:17 递归实现 O(n) O(n)
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        des(list, root);
        return list;
    }

    private void des(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        des(list, root.left);
        des(list, root.right);
        list.add(root.val);
    }

    /**
     * 2020/9/13 23:17 迭代实现 O(n) O(n)
     * 迭代是重复反馈过程的活动，其目的通常是为了逼近所需目标或结果。
     * 每一次对过程的重复称为一次“迭代”，而每一次迭代得到的结果会作为下一次迭代的初始值。
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        TreeNode curr = root;
        TreeNode last = null;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.peek();
            if (curr.right == null || curr.right == last) {
                res.add(curr.val);
                stack.pop();
                last = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }
        return res;
    }
}
