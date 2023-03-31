package com.brian.leet234PalindromeLinkedList;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    ListNode frontNode;
    // 递归
    public boolean isPalindrome(ListNode head) {

        frontNode = head;
        return recursionCheck(head);
    }
    public boolean recursionCheck(ListNode curNode) {
        if (curNode != null) {
            if (!recursionCheck(curNode.next)) {
                return false;
            }
            if (curNode.val != frontNode.val)
                return false;

            frontNode = frontNode.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
