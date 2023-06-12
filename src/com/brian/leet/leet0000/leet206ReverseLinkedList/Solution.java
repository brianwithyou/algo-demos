package com.brian.leet.leet0000.leet206ReverseLinkedList;

import com.brian.util.ListUtil;

import static com.brian.util.ListUtil.ListNode;
import static com.brian.util.ListUtil.printList;
/**
 * @author Brian
 * @date 2023/6/12
 **/
public class Solution {
    public ListNode reverseList(ListNode head) {
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
        ListUtil.ListNode list = ListUtil.createList(new int[]{1, 2, 3, 4, 5}, 5);
        printList(list);
        ListNode listNode = new Solution().reverseList(list);
        printList(listNode);
    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }

}
