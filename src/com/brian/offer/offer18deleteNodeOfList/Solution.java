package com.brian.offer.offer18deleteNodeOfList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 说明：
 * 题目保证链表中节点的值互不相同
 *
 * 链接：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null && pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode list = ListUtil.createList(new int[]{4, 5, 1, 9}, 4);
//        ListNode listNode = new Solution().deleteNode(list, 1);
        ListNode list = ListUtil.createList(new int[]{-3,5,-99}, 3);
        ListNode listNode = new Solution().deleteNode(list, -99);
        ListUtil.printList(listNode);
    }
}
