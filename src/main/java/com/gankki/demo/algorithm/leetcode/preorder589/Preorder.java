package com.gankki.demo.algorithm.leetcode.preorder589;

import java.util.ArrayList;
import java.util.List;

/**
 *  N 叉树前序遍历
 * @author liuhao
 * @date 2020/8/26
 */
public class Preorder {

    public static void main(String[] args) {

    }

    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(list, root);
        return list;
    }

    private void pre(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (!children.isEmpty()) {
            for (Node child : children) {
                pre(list, child);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
