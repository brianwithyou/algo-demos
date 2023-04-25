package com.brian.leet138CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        if (!cachedNode.containsKey(head)) {
            Node newNode = new Node(head.val);

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
