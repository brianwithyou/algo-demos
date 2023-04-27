package com.brian.leet34FindPositionsOfElementInSortedArray;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 * <p>
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 找到结果，中心扩展
                int l = mid - 1, r = mid + 1;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (r < nums.length && nums[r] == target) {
                    r++;
                }
                return new int[]{l + 1, r - 1};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ints = new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);// 3,4
        System.out.println(Arrays.toString(ints));

    }
}
