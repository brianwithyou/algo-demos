package com.brian.leet92ReverseLinkedList2;

/**
 *
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode next = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right; i++) {
            // 一直到right节点
            next = next.next;
        }
        ListNode nextNode = next.next;
        ListNode preNext = pre.next;
        next.next = null;
        pre.next = null;


        pre.next = reverse(preNext);
        preNext.next = nextNode;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
