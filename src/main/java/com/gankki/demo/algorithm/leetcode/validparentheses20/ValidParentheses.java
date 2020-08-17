package com.gankki.demo.algorithm.leetcode.validparentheses20;

import java.util.Stack;

/**
 *
 * @author liuhao
 * @date 2020/8/16
 */
public class ValidParentheses {

    public static void main(String[] args) {

    }
    
    /**
     * 2020/8/16 23:01 O(n) O(n)
     * 替换，最后判断字符串的长度是否为 0.
     */
    public boolean isValid1(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "").replace("[]", "").replace("()", "");
        }
        return s.length() == 0;
    }

    /**
     * 2020/8/16 23:19 O(n) O(n)
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.pop();
                if ((c == '}' && p != '{') || (c == ']' && p != '[')
                || (c == ')' && p != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
