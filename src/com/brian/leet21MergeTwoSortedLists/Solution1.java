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
public class Solution1 {

    /**
     * 1. 递归 Solution
     * 2. 新建链表存储result  Solution1
     * 3. 在原链表上修改指针   Solution2
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode cur1 = list1;
        ListNode cur2 = list2;

        ListNode dummyResult = new ListNode();
        ListNode resultPoint = dummyResult;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                resultPoint.next = new ListNode(cur1.val);
                resultPoint = resultPoint.next;
                cur1 = cur1.next;
            } else {
                resultPoint.next = new ListNode(cur2.val);
                resultPoint = resultPoint.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            resultPoint.next = cur2;
        } else {
            resultPoint.next = cur1;
        }
        return dummyResult.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListUtil.createList(new int[]{1, 2, 4}, 3);
        ListNode list2 = ListUtil.createList(new int[]{1, 3, 4}, 3);

        ListNode listNode = new Solution1().mergeTwoLists(list1, list2);
        ListUtil.printList(listNode);

    }

}
