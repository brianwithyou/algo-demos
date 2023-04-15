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
public class Solution1 {
    /**
     * 左窗口固定，右窗口跟着变动
     */
    public int minSubArrayLen(int target, int[] nums) {

        int rightIdx = -1;
        int leftIdx = 0;
        int sum = 0;
        int result = nums.length + 1;
        while (leftIdx < nums.length) {

            if (rightIdx + 1< nums.length && sum < target) {
                rightIdx++;
                sum += nums[rightIdx];
            } else {
                sum -= nums[leftIdx];
                leftIdx++;
            }

            if (sum >= target) {
                result = Math.min(result, rightIdx - leftIdx + 1);
            }
        }
        return result > nums.length ? 0 : result;
    }

    public static void main(String[] args) {
        // 2
//        int i = new Solution1().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        int i = new Solution1().minSubArrayLen(4, new int[]{1, 4, 4});
        System.out.println(i);
    }
}
