package com.gankki.demo.algorithm.leetcode.levelOrder102;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 *
 * @author liuhao
 * @date 2020/9/2
 */
public class LevelOrder {

    /**
     * 2020/9/2 22:34 O(n) O(n) 递归实现二叉树的层次遍历
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        level(1, result, root);
        return result;
    }

    private void level(int level, List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (result.size() < level) {// 当数组为空时增加数组的长度
            result.add(new ArrayList<>());
        }
        List<Integer> list = result.get(level - 1);// rangeCheck(index) get 方法的数组下标越界是以数组中已添加的元素 size 判断的，不是数组实际长度决定的
        list.add(root.val);
        level(level + 1, result, root.left);
        level(level + 1, result, root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
