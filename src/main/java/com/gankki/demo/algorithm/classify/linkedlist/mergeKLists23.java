package com.gankki.demo.algorithm.classify.linkedlist;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class mergeKLists23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 借助优先级队列实现。
     *
     * 这个算法是面试常考题，它的时间复杂度是多少呢？
     *
     * 优先队列 pq 中的元素个数最多是 k，所以一次 poll 或者 add 方法的时间复杂度是 O(logk)；所有的链表节点都会被加入和弹出 pq，所以算法整体的时间复杂度是 O(Nlogk)，其中 k 是链表的条数，N 是这些链表的节点总数。
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode p = dummy;

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            // poll:检索并删除此队列的头部
            ListNode temp = queue.poll();
            p.next = temp;
            if (temp.next != null) {
                queue.add(temp.next);
            }
            p = p.next;
        }

        return dummy.next;
    }

}
