package com.brian.leet02AddTwoNumbers;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 链接：https://leetcode.cn/problems/add-two-numbers
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode dummyRes = new ListNode(-1);
        ListNode resCur = dummyRes;

        boolean addOne = false;
        while (cur1 != null || cur2 != null) {
            int value;
            if (cur1 == null) {
                value = cur2.val;
            } else if (cur2 == null) {
                value = cur1.val;
            } else {
                value = cur1.val + cur2.val;
            }

            if (addOne) {
                value++;
            }

            if (value >= 10) {
                resCur.next = new ListNode(value % 10);
                resCur = resCur.next;
                addOne = true;
            } else {
                resCur.next = new ListNode(value);
                resCur = resCur.next;
                addOne = false;
            }
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if (addOne) {
            resCur.next = new ListNode(1);
        }
        return dummyRes.next;
    }

    public static void main(String[] args) {
//        ListNode list1 = ListUtil.createList(new int[]{2, 4, 3}, 3);
//        ListNode list2 = ListUtil.createList(new int[]{5, 6}, 2);

        ListNode list1 = ListUtil.createList(new int[]{0}, 1);
        ListNode list2 = ListUtil.createList(new int[]{0}, 1);

        ListNode listNode = new Solution().addTwoNumbers(list1, list2);
        ListUtil.printList(listNode);
    }
}
