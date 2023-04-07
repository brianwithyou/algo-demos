package com.brian.leet143ReorderList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 *
 * 链接：https://leetcode.cn/problems/reorder-list
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public void reorderList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        // 奇数个节点，slow在mid节点处，偶数个节点，在中间前边那个节点处
        ListNode tailList = slow.next;
        slow.next = null;
        ListNode reversedTail = reverse(tailList);

        ListNode l1 = head;
        ListNode l2 = reversedTail;
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }
        cur.next = l1 == null ? l2 : l1;

    }
    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;

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

    public static void main(String[] args) {
        ListNode list = ListUtil.createList(new int[]{1, 2, 3, 4, 5}, 5);

        new Solution().reorderList(list);
        ListUtil.printList(list);
    }
}
