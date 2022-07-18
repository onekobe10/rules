package com.gankki.demo.algorithm.classify.linkedlist;

public class reverseBetween92 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;

    public ListNode reverseN (ListNode head, int left) {
        if (left ==  1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, left - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
