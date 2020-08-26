package com.gankki.demo.algorithm.leetcode.getLeastNumbers_offer40;

import org.apache.ibatis.annotations.Param;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author liuhao
 * @date 2020/8/26 
 */
public class GetLeastNumbers {

    public static void main(String[] args) {

    }

    /**
     * 2020/8/26 22:53 O(n) O(1)
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }

        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i : arr) {
            if (pq.size() < k) {
                pq.offer(i);
            } else if (pq.peek() > i) {
                pq.poll();
                pq.offer(i);
            }
        }

        int[] res = new int[k];
        int idx = 0;
        for (Integer i : pq) {
            res[idx++] = i;
        }
        return res;
    }

}
