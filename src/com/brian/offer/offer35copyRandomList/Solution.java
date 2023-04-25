package com.brian.offer.offer35copyRandomList;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 *
 * 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    // oldNode -> newNode
    Map<Node, Node> cachedNode = new HashMap<>();
    // 深拷贝
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node newNode = new Node(head.val);
            // 必须是递归之前put，要不然上边的containsKey无用
            cachedNode.put(head, newNode);

            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }

        return cachedNode.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
