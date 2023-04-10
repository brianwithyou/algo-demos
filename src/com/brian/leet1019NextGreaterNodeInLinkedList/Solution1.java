package com.brian.leet1019NextGreaterNodeInLinkedList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

import java.util.*;

/**
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为n的链表head
 *
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 *
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置answer[i] = 0。
 *
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 
 * 链接：https://leetcode.cn/problems/next-greater-node-in-linked-list
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    /**
     * 单调栈，找出「下一个更大的元素」是经典的可以用单调栈解决的问题。
     */
    public int[] nextLargerNodes(ListNode head) {

        List<Integer> result = new ArrayList<>();
        Deque<int[]> stack = new ArrayDeque<>();
        ListNode cur = head;

        // 记录元素val在的索引
        int idx = -1;
        while (cur != null) {
            idx++;

            // 很重要，要不然会 越界
            result.add(0);

            while (!stack.isEmpty() && stack.peek()[0] < cur.val) {
                result.set(stack.pop()[1], cur.val);
            }

            stack.push(new int[]{cur.val, idx});
            cur = cur.next;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
//        ListNode list = ListUtil.createList(new int[]{2, 1, 5}, 3);
        ListNode list = ListUtil.createList(new int[]{2,7,4,3,5}, 5);
        int[] ints = new Solution1().nextLargerNodes(list);
        System.out.println(Arrays.toString(ints));
    }
}
