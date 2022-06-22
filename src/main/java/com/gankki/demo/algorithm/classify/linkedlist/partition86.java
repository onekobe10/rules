package com.gankki.demo.algorithm.classify.linkedlist;

public class partition86 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

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

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy1, p2 = dummy2;

        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next;

        return dummy1.next;
    }

    /**
     * 将 大 的 子链表的尾部置为 null
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy1, p2 = dummy2;

        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            p = p.next;
        }
        p2.next = null;
        p1.next = dummy2.next;

        return dummy1.next;
    }

    /**
     * 去掉 head 的临时变量
     * @param head
     * @param x
     * @return
     */
    public ListNode partition2(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy1, p2 = dummy2;

        while (head != null) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
            } else {
                p1.next = head;
                p1 = p1.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = dummy2.next;

        return dummy1.next;
    }


}
