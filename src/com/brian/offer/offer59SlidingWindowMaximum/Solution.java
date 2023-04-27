package com.brian.offer.offer59SlidingWindowMaximum;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 
 * 提示：
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤nums.length。
 *
 * 链接：https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0, right = -1;
        int[] res = new int[nums.length - k + 1];
        int cur = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        while (right < nums.length) {
            while (right - left + 1 < k) {
                right++;
                queue.add(new int[]{nums[right], right});
            }
            res[cur] = queue.peek()[0];
            cur++;
            if (right + 1 == nums.length) {
                break;
            }
            left++;
            right++;
            queue.add(new int[]{nums[right], right});
            // 一直移除max元素，直到移除了left左边那个元素，不超时，但是Solution0, 移除指定元素 超时
            while (queue.peek()[1] < left) {
                queue.poll();
            }
        }
        return res;
    }

}
