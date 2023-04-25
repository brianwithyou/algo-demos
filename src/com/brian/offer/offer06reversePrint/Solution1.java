package com.brian.offer.offer06reversePrint;

import com.brian.util.ListUtil.ListNode;

import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 0 <= 链表长度 <= 10000
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    LinkedList<Integer> res = new LinkedList<>();
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            res.addFirst(cur.val);
            cur = cur.next;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
