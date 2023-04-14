package com.brian.leet148SortList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * 链接：https://leetcode.cn/problems/sort-list
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    // O(NlogN)  O(logN)
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null)
            return null;
        if (head == tail) {
            tail = null;
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        ListNode mid = slow;
        ListNode midNext = slow.next;

        slow.next = null;

        ListNode front = sortList(head, mid);
        ListNode end = sortList(midNext, tail);
        return merge(front, end);
    }

    private ListNode merge(ListNode front, ListNode end) {

        ListNode dummy = new ListNode();
        ListNode idx1 = front;
        ListNode idx2 = end;
        ListNode pre = dummy;

        while (idx1 != null && idx2 != null) {
            if (idx1.val < idx2.val) {
                pre.next = idx1;
                idx1 = idx1.next;
                pre = pre.next;
            } else {
                pre.next = idx2;
                idx2 = idx2.next;
                pre = pre.next;
            }
        }
        if (idx1 == null) {
            pre.next = idx2;
        }
        if (idx2 == null) {
            pre.next = idx1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode list1 = ListUtil.createList(new int[]{1, 3, 5, 7}, 4);
//        ListNode list2 = ListUtil.createList(new int[]{2, 4, 6}, 3);
//        ListNode merge = new Solution().merge(list1, list2);
//        ListUtil.printList(merge);

//        ListNode data = ListUtil.createList(new int[]{4,2,1,3}, 4);
        ListNode data = ListUtil.createList(new int[]{-1,5,3,4,0}, 5);
        ListNode listNode = new Solution().sortList(data);
        ListUtil.printList(listNode);
    }
}
