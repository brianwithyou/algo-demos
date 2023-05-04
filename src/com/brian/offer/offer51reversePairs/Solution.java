package com.brian.offer.offer51reversePairs;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        int[] sortedArray = new int[right - left + 1];
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int cur = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sortedArray[cur++] = nums[i++];
            } else {    // 左边的值 大于右边的值了，
                // 统计逆序对，nums[i] > j处的值了，那么[i...mid]的所有值都大于j处的值
                count += (mid - i + 1);
                sortedArray[cur++] = nums[j++];
            }
        }

        while (i <= mid) {
            sortedArray[cur++] = nums[i++];
        }
        while (j <= right) {
            sortedArray[cur++] = nums[j++];
        }

        for (int k = 0; k < sortedArray.length; k++) {
            nums[left + k] = sortedArray[k];
        }
    }

    public static void main(String[] args) {
//        int count = new Solution().reversePairs(new int[]{7, 5, 6, 4});
        int count = new Solution().reversePairs(new int[]{4, 5, 6, 7});
        System.out.println(count);
    }
}
