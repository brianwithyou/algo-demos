package com.brian.leet24SwapNodesInPairs;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode pair1 = pre.next;
            ListNode pair2 = pair1.next;
            ListNode next = pair2.next;

            pre.next = pair2;
            pair2.next = pair1;
            pair1.next = next;

            pre = pair1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = ListUtil.createList(new int[]{1, 2, 3, 4}, 4);
        ListNode listNode = new Solution().swapPairs(list);
        ListUtil.printList(listNode);
    }
}
