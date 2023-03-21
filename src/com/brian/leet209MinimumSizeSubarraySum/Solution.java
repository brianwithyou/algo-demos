package com.brian.leet209MinimumSizeSubarraySum;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 * @link <a href="https://leetcode.cn/problems/minimum-size-subarray-sum"></a>
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 求解 连续数组问题，通常用滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {

        int res = nums.length + 1;

        // [left...right]之间是满足 sum >= target的
        int left = 0;
        int right = -1;
        int sum = 0;

        while (left < nums.length) {

            if (right + 1 < nums.length && sum < target){
                right++;
                sum += nums[right];
            } else {
                sum -= nums[left];
                left++;
            }
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {
        int i = new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println(i);
    }
}
