package com.gankki.demo.algorithm.leetcode.minMutation433;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 最小基因变化
 * @author liuhao
 * @date 2020/9/2 
 */
public class MinMutation {

    public static void main(String[] args) {

    }

    /**
     * 2020/9/2 23:10 利用队列的 BFS 实现
     */
    public int minMutation1(String start, String end, String[] bank) {
        HashSet<String> bank_library = new HashSet<>();
        for (String library : bank) {
            bank_library.add(library);
        }
        char[] banks = {'A', 'C', 'G', 'T'};
        LinkedList<String> dequeue = new LinkedList<>();
        dequeue.offer(start);
        int count = 0;
        HashSet<String> visited = new HashSet<>();
        while (!dequeue.isEmpty()) {
            int size = dequeue.size();
            while (size-- > 0) {
                String poll = dequeue.poll();
                if (poll.equals(end)) return count;
                char[] curr = poll.toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char old = curr[i];
                    for (char b : banks) {
                        curr[i] = b;
                        String newString = new String(curr);
                        if (!visited.contains(newString) && bank_library.contains(newString)) {
                            visited.add(newString);
                            dequeue.offer(newString);
                        }
                    }
                    curr[i] = old;
                }
            }
            count++;
        }
        return -1;
    }

}
