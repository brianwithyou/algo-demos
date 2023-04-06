package com.brian.leet61RotateList;

import com.brian.util.ListUtil.ListNode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = head;

        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        if (length == 0)
            return head;
        // 向右移动k位
        k = k % length;
        if (k == 0)
            return head;

        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        // fast就是旧的尾节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
}
