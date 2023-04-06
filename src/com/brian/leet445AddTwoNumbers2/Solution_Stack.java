package com.brian.leet445AddTwoNumbers2;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

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
public class Solution_Stack {

    /**
     * 借助3个栈，顺序创建链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null) {
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }

        Deque<Integer> resultStack = new ArrayDeque<>();
        ListNode dummyResult = new ListNode(-1);
        ListNode resultPoint = dummyResult;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int value;
            if (stack1.isEmpty()) {
                value = stack2.pop() + carry;
            } else if (stack2.isEmpty()) {
                value = stack1.pop() + carry;
            } else {
                value = stack1.pop() + stack2.pop() + carry;
            }
            carry = value / 10;
            value = value % 10;

            resultStack.push(value);
//            resultPoint.next = new ListNode(value);
//            resultPoint = resultPoint.next;
        }
        if (carry != 0) {
//            resultPoint.next = new ListNode(carry);
            resultStack.push(carry);
        }

        while (!resultStack.isEmpty()) {
            resultPoint.next = new ListNode(resultStack.pop());
            resultPoint = resultPoint.next;
        }

        return dummyResult.next;
    }

    public static void main(String[] args) {
        ListNode list1 = ListUtil.createList(new int[]{7, 2, 4, 3}, 4);
        ListNode list2 = ListUtil.createList(new int[]{5, 6, 4}, 3);
//        ListNode list1 = ListUtil.createList(new int[]{1}, 1);
//        ListNode list2 = ListUtil.createList(new int[]{9, 9}, 2);
        ListNode listNode = new Solution_Stack().addTwoNumbers(list1, list2);
        ListUtil.printList(listNode);
    }

}
