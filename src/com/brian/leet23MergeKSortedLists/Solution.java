package com.brian.leet23MergeKSortedLists;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /// 错误示例, merge的时候需要，用之前merge出来的链表进行merge
    /**
     * public ListNode mergeKLists(ListNode[] lists) {
     *         ListNode dummy = new ListNode();
     *         ListNode head = lists[0];
     *         for (int i = 1; i < lists.length; i++) {
     *             dummy.next = merge(head, lists[i]);
     *         }
     *         return dummy.next;
     *     }
     */

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            // merge方法内传入 上次计算出的ans
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode[] lists = new ListNode[] {list1, list2, list3};

        new Solution().mergeKLists(lists);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
