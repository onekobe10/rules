package com.gankki.demo.algorithm.leetcode.levelOrde429;

import java.util.ArrayList;
import java.util.List;

/**
 * N 叉树的层级遍历
 *
 * @author liuhao
 * @date 2020/8/26
 */
public class LevelOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        level(lists, root, 0);
        return lists;
    }

    private void level(List<List<Integer>> lists, Node root, int depth) {
        if (root == null) {
            return;
        }
        if (depth + 1 > lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        for (Node node : root.children) {
            if (node != null) {
                level(lists, node, depth + 1);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
