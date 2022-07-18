package com.gankki.demo.algorithm.classify.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class largestValues515 {

    public List<Integer> largestValues(maxDepth104.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        largest(1, result, root);
        return result;
    }

    public void largest(int level, List<Integer> result, maxDepth104.TreeNode root) {
        if (root == null) {
            return;
        }
        int val = root.val;
        if (result.size() < level) {
            result.add(val);
        }
        result.set(level - 1, Math.max(result.get(level - 1), val));
        largest(level + 1, result, root.left);
        largest(level + 1, result, root.right);
    }

}
