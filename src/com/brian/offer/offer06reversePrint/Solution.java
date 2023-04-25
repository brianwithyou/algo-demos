package com.brian.offer.offer06reversePrint;

import com.brian.util.ListUtil.ListNode;

import java.util.ArrayList;
import java.util.List;

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
public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode cur = reverse(head);

        List<Integer> res = new ArrayList<>();
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public ListNode reverse(ListNode head) {
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
}
