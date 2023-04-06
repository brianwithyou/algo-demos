package com.brian.leet203RemoveLinkedListElements;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        // 由于可能删除head节点，所以需要个dummyHead
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 由于删除节点，需要记录节点的上一个节点，所以用pre指针，而不是cur指针
        ListNode pre = dummyHead;

        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list = ListUtil.createList(new int[]{1, 2, 6, 3, 4, 5, 6}, 6); // 1,2,3,4,5

        ListNode listNode = new Solution().removeElements(list, 6);
        ListUtil.printList(listNode);
    }
}
