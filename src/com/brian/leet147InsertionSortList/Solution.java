package com.brian.leet147InsertionSortList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 147.对链表进行插入排序
 *
 * 输入: head = [4,2,1,3]
 * 输出: [1,2,3,4]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode sortedEnd = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val < sortedEnd.val) {
                ListNode next = cur.next;
                ListNode pre = dummyHead;
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                sortedEnd.next = cur.next;
                ListNode greaterNode = pre.next;
                pre.next = cur;
                cur.next = greaterNode;

                cur = next;

            } else {
                sortedEnd.next = cur;
                sortedEnd = sortedEnd.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list = ListUtil.createList(new int[]{4, 2, 1, 3}, 4);
        ListNode listNode = new Solution().insertionSortList(list);
        ListUtil.printList(listNode);
    }
}
