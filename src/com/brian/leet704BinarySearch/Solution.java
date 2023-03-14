package com.brian.leet704BinarySearch;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int search(int[] nums, int target) {

        int mid = nums.length / 2;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[mid] > target) {
                right = mid - 1;
                mid = left + (right - left) / 2;
            } else if (nums[mid] < target) {
                left = mid + 1;
                mid = left + (right - left) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
