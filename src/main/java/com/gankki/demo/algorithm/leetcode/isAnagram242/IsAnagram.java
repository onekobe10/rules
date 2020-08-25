package com.gankki.demo.algorithm.leetcode.isAnagram242;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效字母异位词
 * @author liuhao
 * @date 2020/8/25
 */
public class IsAnagram {

    public static void main(String[] args) {

    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charS = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< charS.length; i++) {
            if (!map.containsKey(charS[i])) {
                map.put(charS[i], 1);
            } else {
                int value = map.get(charS[i]);
                map.put(charS[i], ++value);
            }
        }
        char[] charT = t.toCharArray();
        for (int i = 0; i< charT.length; i++) {
            if (!map.containsKey(charT[i])) {
                return false;
            } else {
                int value = map.get(charT[i]);
                if (value == 0) {
                    return false;
                }
                map.put(charT[i], --value);
            }
        }
        return true;
    }
}
