package com.brian.leet1019NextGreaterNodeInLinkedList;

import com.brian.util.ListUtil;
import com.brian.util.ListUtil.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> result = new ArrayList<>();

        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow.next;
            while (fast != null && fast.val <= slow.val) {
                fast = fast.next;
            }
            if (fast == null) {
                result.add(0);
            } else {
                result.add(fast.val);
            }
            slow = slow.next;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
//        ListNode list = ListUtil.createList(new int[]{2, 1, 5}, 3);
        ListNode list = ListUtil.createList(new int[]{2,7,4,3,5}, 5);
        int[] ints = new Solution().nextLargerNodes(list);
        System.out.println(Arrays.toString(ints));
    }
}
