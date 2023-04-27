package com.brian.leet239SlidingWindowMaximum;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 链接：https://leetcode.cn/problems/sliding-window-maximum
 *
 * @author : brian
 * @since 0.1
 */
public class Solution0_TLE {
    // TLE
    public int[] maxSlidingWindow(int[] nums, int k) {

        int left = 0, right = -1;
        int[] res = new int[nums.length - k + 1];
        int cur = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (right < nums.length) {
            while (right - left + 1 < k) {
                right++;
                queue.add(nums[right]);
            }
            res[cur] = queue.peek();
            cur++;
            if (right + 1 == nums.length) {
                break;
            }
            queue.remove(nums[left]);
            left++;
            right++;
            queue.add(nums[right]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new Solution0_TLE().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);


//        int[] ints = new Solution().maxSlidingWindow(new int[]{1}, 1);
        System.out.println(Arrays.toString(ints));
    }
}
