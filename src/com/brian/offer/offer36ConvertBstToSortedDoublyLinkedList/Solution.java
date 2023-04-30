package com.brian.offer.offer36ConvertBstToSortedDoublyLinkedList;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    Node pre, head;
    /**
     * 因为需要头尾节点互相指向，所以需要两个指针记录下 头尾节点
     */
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        // 不能在这里初始化，因为这个root不是head节点，最左侧的节点才是head节点
//        head = root;
//        pre.right = root;

        dfs(root);

        // 递归结束，拼接头尾
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node root) {

        if (root == null)
            return;

        dfs(root.left);

        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;

        dfs(root.right);

    }

    public static void main(String[] args) {
        Node root =new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        Node node = new Solution().treeToDoublyList(root);
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
