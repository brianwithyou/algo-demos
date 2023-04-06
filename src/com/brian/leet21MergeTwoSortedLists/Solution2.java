package com.brian.leet21MergeTwoSortedLists;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution2 {

    /**
     * 1. 递归 Solution
     * 2. 新建链表存储result  Solution1
     * 3. 在原链表上修改指针   Solution2
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode list1 = ListUtil.createList(new int[]{1, 2, 4}, 3);
        ListNode list2 = ListUtil.createList(new int[]{1, 3, 4}, 3);

        ListNode listNode = new Solution2().mergeTwoLists(list1, list2);
        ListUtil.printList(listNode);

    }

}
