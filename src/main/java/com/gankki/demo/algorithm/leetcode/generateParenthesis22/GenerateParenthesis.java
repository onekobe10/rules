package com.gankki.demo.algorithm.leetcode.generateParenthesis22;

import javax.xml.stream.events.DTD;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 *
 * @author liuhao
 * @date 2020/8/30
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> result = generateParenthesis2(2);
        for (String s : result) {
            System.out.println(s);
        }
    }

    /**
     * 2020/8/30 18:29 O(n^2) O(n) 暴力解法，先统计出所有可能性，然后再过滤有效的
     * 一直在一个数组上操作，但是递归栈占用了内存空间，因此，空间复杂度为 O(n)
     */
    public List<String> generateParenthesis1(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[n * 2], 0, result);
        return result;
    }

    private void generateAll(char[] chars, int pos, List<String> result) {
        if (chars.length == pos) {
            if (valid(chars)) {
                result.add(new String(chars));
            }
        } else {
            chars[pos] = '(';
            generateAll(chars, pos + 1, result);
            chars[pos] = ')';
            generateAll(chars, pos + 1, result);
        }
    }

    private boolean valid(char[] chars) {
        int temp = 0;
        for (char c : chars) {
            if (c == '(') {
                ++temp;
            } else {
                --temp;
            }
            if (temp < 0) {
                return false;
            }
        }
        return temp == 0;
    }

    /**
     * 2020/8/30 18:45 回溯法，用完的括号删除，重新利用字符串 O(n) O(1)
     */
    public static List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        generateAll2(new StringBuilder(), 0, 0, result, n);
        return result;
    }

    private static void generateAll2(StringBuilder sb, int left, int right, List<String> result, int max) {
        if (sb.length() == max * 2) {
            result.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append("(");
            generateAll2(sb, left + 1, right, result, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(")");
            generateAll2(sb, left, right + 1, result, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static List<String> generateParenthesis3(int n) {
        List<String> result = new ArrayList<>();
        generateAll3(0, 0, n, "", result);
        return result;
    }

    private static void generateAll3(int left, int right, int n, String str, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (left < n) {
            generateAll3(left + 1, right, n, str + "(", result);
        }

        if (left > right) {
            generateAll3(left, right + 1, n, str + ")", result);
        }
    }

}
