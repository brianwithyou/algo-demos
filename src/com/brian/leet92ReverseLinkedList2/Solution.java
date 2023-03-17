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
public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        // 待反转 left 的前一个节点
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode rightNode = dummy;

        // right所在节点，需要走 right步
        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }

        ListNode next = rightNode.next;
        ListNode leftNode = pre.next;

        // 断开链表
        pre.next = null;
        rightNode.next = null;

        pre.next = reverse(leftNode);
        leftNode.next = next;

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

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
