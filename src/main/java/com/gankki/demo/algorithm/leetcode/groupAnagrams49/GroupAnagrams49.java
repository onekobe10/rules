package com.gankki.demo.algorithm.leetcode.groupAnagrams49;

import sun.security.util.Length;

import java.util.*;

/**
 * 字母异位词分组
 * @author liuhao
 * @date 2020/8/19 
 */
public class GroupAnagrams49 {

    public static void main(String[] args) {
       String[] nums = {"eat","tea","tan","ate","nat","bat"};
       groupAnagrams4(nums);
    }

    /**
     * 2020/8/20 0:00 O(n^2) O(1)
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        boolean[] userd = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>();
            if (!userd[i]) {
                temp.add(strs[i]);
                for (int j = i + 1; j < strs.length; j++) {
                    if (equals(strs[i], strs[j])) {
                        userd[j] = true;
                        temp.add(strs[j]);
                    }
                }
            }
            if (!temp.isEmpty()) {
                resultList.add(temp);
            }
        }

        return resultList;
    }

    private boolean equals(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);

        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);

        return new String(a1).equals(new String(a2));
    }

    /**
     * 2020/8/20 0:01 O(nlogn) O(1)
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] strA = str.toCharArray();
            Arrays.sort(strA);
            String newStr = new String(strA);
            if (!map.containsKey(newStr)) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(newStr, temp);
            } else {
                List<String> temp = map.get(newStr);
                temp.add(str);
            }
        }
        resultList.addAll(map.values());
        return resultList;
    }

    /**
     * 2020/8/20 0:01
     */
    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            int key = 1;
            for (int j = 0; j < chars.length; j++) {
                key *= prime[chars[j] - 'a'];
            }
            if (!map.containsKey(key)) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(key, temp);
            } else {
                List<String> temp = map.get(key);
                temp.add(strs[i]);
            }
        }
        resultList.addAll(map.values());
        return resultList;
    }

    /**
     * 2020/8/20 0:01
     */
    public static List<List<String>> groupAnagrams4(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] num = new int[26];
            char[] chars = strs[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                num[chars[j] - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int x = 0; x < num.length; x++) {
                if (num[x] != 0) {
                    key.append("#").append(x).append(num[x]);
                }
            }
            if (!map.containsKey(key.toString())) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(key.toString(), temp);
            } else {
                map.get(key.toString()).add(strs[i]);
            }
        }
        resultList.addAll(map.values());
        return resultList;
    }


}
