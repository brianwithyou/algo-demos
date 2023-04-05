package com.brian.leet328OddEvenLinkedList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

/**
 * 328. 奇偶链表
 * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 *
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;

            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


}
