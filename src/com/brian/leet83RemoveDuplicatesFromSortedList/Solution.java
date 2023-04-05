package com.brian.leet83RemoveDuplicatesFromSortedList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (next != null && next.val == cur.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = ListUtil.createList(new int[]{1, 1, 2, 2, 2}, 5);
        ListUtil.printList(list);

        ListNode listNode = new Solution().deleteDuplicates(list);
        ListUtil.printList(listNode);
    }
}
