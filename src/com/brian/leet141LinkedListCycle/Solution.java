package com.brian.leet141LinkedListCycle;

/**
 * 判断链表是否有环
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list
 * that can be reached again by continuously following thenextpointer.
 * Internally, posis used to denote the index of the node thattail'snextpointer is connected to.
 * Note that posis not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * 【easy】
 * 类似题目
 * @see <a href="https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/">abc</>
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
