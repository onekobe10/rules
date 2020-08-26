package com.gankki.demo.algorithm.leetcode.postorder590;

import java.util.ArrayList;
import java.util.List;

/**
 *  n 叉树的后序遍历
 * @author liuhao
 * @date 2020/8/26
 */
public class Postorder {

    public static void main(String[] args) {

    }

    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        post(list, root);
        return list;
    }

    /**
     * 2020/8/26 21:28
     */
    private void post(List<Integer> list, Node root) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (!children.isEmpty()) {
            for (Node child : children) {
                post(list, child);
            }
        }
        list.add(root.val);
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
