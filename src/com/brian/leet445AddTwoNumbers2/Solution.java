package com.brian.leet445AddTwoNumbers2;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 *
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 *
 * 进阶：如果输入链表不能翻转该如何解决？
 *
 * 链接：https://leetcode.cn/problems/add-two-numbers-ii
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);

        ListNode p1 = reverse1;
        ListNode p2 = reverse2;
        // 进位
        int carry = 0;

        ListNode dummyResult = new ListNode(-1);
        ListNode resultPoint = dummyResult;
        while (p1 != null || p2 != null) {
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;
            int value = v1 + v2 + carry;

            resultPoint.next = new ListNode(value % 10);

            carry = value / 10;

            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
            resultPoint = resultPoint.next;
        }
        if (carry != 0) {
            resultPoint.next = new ListNode(carry);
        }
        return reverse(dummyResult.next);
    }
    public ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public static void main(String[] args) {
//        ListNode list1 = ListUtil.createList(new int[]{7, 2, 4, 3}, 4);
//        ListNode list2 = ListUtil.createList(new int[]{5, 6, 4}, 3);
        ListNode list1 = ListUtil.createList(new int[]{1}, 1);
        ListNode list2 = ListUtil.createList(new int[]{9, 9}, 2);
        ListNode listNode = new Solution().addTwoNumbers(list1, list2);
        ListUtil.printList(listNode);
    }

}
