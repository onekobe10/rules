package com.gankki.demo.algorithm.classify.array;

public class longestPalindrome5 {

    /**
     * 找回文串的难点在于，回文串的的长度可能是奇数也可能是偶数，解决该问题的核心是从中心向两端扩散的双指针技巧。
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String o = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            o = s1.length() > o.length() ? s1 : o;
            o = s2.length() > o.length() ? s2 : o;
        }
        return o;
    }

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return s.substring(l + 1, r);
    }
}
