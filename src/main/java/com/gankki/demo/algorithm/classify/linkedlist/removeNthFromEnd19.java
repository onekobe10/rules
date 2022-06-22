package com.gankki.demo.algorithm.classify.linkedlist;

public class removeNthFromEnd19 {

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
     * 单链表的倒数第 k 个节点（一种思想，快慢指针判断）
     *
     *
     * 第一种方式：如果链表长度为 5（l，则求倒数第 3（n） 元素，则就是求正数的 5 - 3 + 1。
     * 即求倒数的 n，可以转变为求正数的 k： k = l - n + 1。不过这种方式需要提前知道链表的长度 l，一般不给链表的长度，也是需要遍历的。
     * 这种方式需要两次遍历链表
     *
     * 第二种方式：快慢指针，如果要求倒数 k， 则让第一个指针先跑 k，此时第二个指针指得到头节点，然后第一、二个指针同时开跑，第一个指针跑到链表尾部时，第二个指针在的位置就是倒数第 k 个元素的位置。
     *
     *
     * @param head
     * @param k
     * @return
     */
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        // 删除倒数第 K 个，就要找到倒数第 K + 1 个
        ListNode delete = findFromEnd(dummy, n + 1);
        delete.next = delete.next.next;
        return dummy.next;
    }

}
