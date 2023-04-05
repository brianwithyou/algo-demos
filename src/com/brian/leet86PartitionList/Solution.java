package com.brian.leet86PartitionList;


import com.brian.util.ListUtil;

import static com.brian.util.ListUtil.ListNode;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 链接：https://leetcode.cn/problems/partition-list
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode();
        ListNode largeList = new ListNode();

        ListNode smallCur = smallList;
        ListNode largeCur = largeList;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                smallCur.next = new ListNode(cur.val);
                smallCur = smallCur.next;
            } else {
                largeCur.next = new ListNode(cur.val);
                largeCur = largeCur.next;
            }
            cur = cur.next;
        }
        smallCur.next = largeList.next;
        return smallList.next;
    }

    public static void main(String[] args) {
        ListNode list = ListUtil.createList(new int[]{1, 4, 3, 2, 5, 2}, 6);
        ListUtil.printList(list);
        ListNode partition = new Solution().partition(list, 3);
        ListUtil.printList(partition);
    }
}
