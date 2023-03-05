package com.brian.leet06ReverseLinkedList;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * @author : brian
 * @since 0.1
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {

        return null;
    }

    public static void main(String[] args) {
        int[] data = new int[] {1, 2, 3, 4, 5};

        ListNode head = new ListNode(data[0]);
        head.next = new ListNode(data[1]);
        head.next.next = new ListNode(data[2]);
        head.next.next.next = new ListNode(data[3]);
        head.next.next.next.next = new ListNode(data[4]);

//        while (head != null) {
//            System.out.printf(head.val + ", ");
//            head = head.next;
//        }


        ListNode temp = new Solution1().reverseList(head);

        while (temp != null) {
            System.out.printf(temp.val + ", ");
            temp = temp.next;
        }

    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
