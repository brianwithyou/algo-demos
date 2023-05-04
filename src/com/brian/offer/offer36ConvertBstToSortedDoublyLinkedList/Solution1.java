package com.brian.offer.offer36ConvertBstToSortedDoublyLinkedList;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    /**
     * 好题，思路参考Solution
     */
    public Node treeToDoublyList(Node root) {

        return null;
    }


    public static void main(String[] args) {
        Node root =new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        Node node = new Solution1().treeToDoublyList(root);
        Node cur = node;
        while (cur != null) {
            System.out.printf(cur.val + " -> ");
            cur = cur.right;

        }
        System.out.println();

    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
