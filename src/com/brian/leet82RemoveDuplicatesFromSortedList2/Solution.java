package com.brian.leet82RemoveDuplicatesFromSortedList2;

import com.brian.util.ListUtil;

import static com.brian.util.ListUtil.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        // 可能删除head节点，使用dummyHead更方便
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            if (next.val == next.next.val) {
                int val = next.val;
                while (next != null && next.val == val) {
                    next = next.next;
                    cur.next = next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        ListNode list = ListUtil.createList(new int[]{1, 1, 1, 2, 3}, 5);
        ListNode list = ListUtil.createList(new int[]{1,2,3,3,4,4,5}, 7);
        ListNode listNode = new Solution().deleteDuplicates(list);
        ListUtil.printList(listNode);
    }
}
