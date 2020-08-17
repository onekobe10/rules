package com.gankki.demo.algorithm.leetcode.minstack;

import java.util.Stack;

/**
 * 最小栈
 * @author liuhao
 * @date 2020/8/17 
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    /**
     * 3 4 1 1 2 5
     *
     * 3 4 1 1 2 5
     *
     * 3 1 1
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            int p = minStack.peek();
            if (x <= p) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int p = stack.peek();
        stack.pop();

        int m = minStack.peek();
        if (p == m) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
