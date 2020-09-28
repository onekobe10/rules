package com.gankki.demo.algorithm.leetcode.Trie208;

/**
 * 前缀树、字典树
 *
 * @author liuhao
 * @date 2020/9/23
 */
public class Trie {
    private TrieNode root;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            if (!node.containsKey(wordChar)) {
                node.put(wordChar, new TrieNode());
            }
            node = node.get(wordChar);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            if (node.containsKey(wordChar)) {
                node = node.get(wordChar);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char wordChar = prefix.charAt(i);
            if (node.containsKey(wordChar)) {
                node = node.get(wordChar);
            } else {
                return false;
            }
        }
        return true;
    }

    class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

}
