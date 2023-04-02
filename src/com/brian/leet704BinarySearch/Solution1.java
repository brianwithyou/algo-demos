package com.brian.leet704BinarySearch;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
