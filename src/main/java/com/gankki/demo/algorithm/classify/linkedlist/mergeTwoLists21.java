package com.gankki.demo.algorithm.classify.linkedlist;
/**
 * 
 * @author liuhao
 * @date 2020/8/14 
 */
public class mergeTwoLists21 {
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
     * 合并两个有序链表
     *
     *
     * 要知道一个源头，必须是返回 m.next，如果不是 next
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode m = new ListNode(), n = m;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                n.next = p1;
                p1 = p1.next;
            } else {
                n.next = p2;
                p2 = p2.next;
            }
            n = n.next;
        }

        if (p1 != null) {
            n.next = p1;
        }

        if (p2 != null) {
            n.next = p2;
        }

        return m.next;
    }

    /**
     * 合并两个有序链表
     * list1、list2 可以不用临时变量
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode m = new ListNode(), n = m;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                n.next = list1;
                list1 = list1.next;
            } else {
                n.next = list2;
                list2 = list2.next;
            }
            n = n.next;
        }

        if (list1 != null) {
            n.next = list1;
        }

        if (list2 != null) {
            n.next = list2;
        }

        return m.next;
    }

    /**
     * 合并两个有序链表
     *
     *
     * 错误例子，指针一直在走，因此要保留头指针，作为结果返回。
     *
     * 这里 n 和 m 由于 n = list1 的指向， n 和 m 之间已经没有关系了。
     *
     * 代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 dummy 节点。你可以试试，如果不使用 dummy 虚拟节点，代码会复杂很多，而有了 dummy 节点这个占位符，可以避免处理空指针的情况，降低代码的复杂性。
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode m = new ListNode(7), n = m;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                n = list1;
                list1 = list1.next;
            } else {
                n = list2;
                list2 = list2.next;
            }
            n = n.next;
        }

        if (list1 != null) {
            n = list1;
        }

        if (list2 != null) {
            n = list2;
        }

        return m;
    }

}
