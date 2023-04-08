package com.brian.offer52TheFIrstCommonNodeOfTwoLists;

import com.brian.util.ListUtil.ListNode;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 链接：https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    /**
     * TimeComplexity O(m+n)
     * SpaceComplexity O(1)
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;
        // (最多)两个指针都移动m+n次，两个指针同时为null，结束循环
        while (pointerA != pointerB) {
            // 不能用pointerA.next == null判断，因为  期望pointerA、pointerB能指到 null节点，然后结束
//            pointerA = pointerA.next == null ? headB : pointerA.next;
//            pointerB = pointerB.next == null ? headA : pointerB.next;
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }
}
