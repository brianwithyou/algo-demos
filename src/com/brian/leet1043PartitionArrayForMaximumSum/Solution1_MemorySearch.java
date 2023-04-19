package com.brian.leet1043PartitionArrayForMaximumSum;

/**
 * 1043. 分隔数组以得到最大和
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 *
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 *
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 *
 * 输入：arr = [1], k = 1
 * 输出：1
 * 提示：
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 *
 * 链接：https://leetcode.cn/problems/partition-array-for-maximum-sum
 * @author : brian
 * @since 0.1
 */
public class Solution1_MemorySearch {

    int n;
    int[] memory;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        memory = new int[n + 1];
        return maxSumAfterPartitioning(arr, k, -1);
    }
    public int maxSumAfterPartitioning(int[] arr, int k, int lastEnd) {

        if (lastEnd == n - 1) {
            return 0;
        }
        if (lastEnd + k >= n) {
            return getMax(arr, lastEnd + 1, n - 1) * (n - lastEnd - 1);
        }
        if (memory[lastEnd + 1] != 0) {
            return memory[lastEnd + 1];
        }
        int sum = 0;
        for (int i = 1; i <= k; i++) {
            int stepSum = getMax(arr, lastEnd + 1, lastEnd + i) * i;
            int innerMax = maxSumAfterPartitioning(arr, k, lastEnd + i);

            sum = Math.max(sum, stepSum + innerMax);

//            System.out.printf("取[%s, %s]的最大值，stepSum: %s, + 内层最大值：%s  = %s\n", arr[lastEnd + 1], arr[lastEnd + i], stepSum, innerMax, stepSum + innerMax);
        }
        memory[lastEnd + 1] = sum;
        return sum;
    }
    public int getMax(int[] arr, int left, int right) {
        int max = arr[left];
        for (int i = left + 1; i <= right; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
//        int sum = new Solution1_MemorySearch().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3);    // 84
        int sum = new Solution1_MemorySearch().maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 3);  // 78
//        int sum = new Solution1_MemorySearch().maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4);  // 83
//        int sum = new Solution1_MemorySearch().maxSumAfterPartitioning(new int[]{581920,200100,526972,677934,989025,294832,581857,663919,961334,1881,859626,251114,361905,867006,86001,836946,894279,859796,750025,898166,674980,939280,458563,117387,403337,961067,589597,73584,178968,955900,755634,609754,97612,19699,843950,907919,883083,522938,670930,671679,390248,704834,188158,226340,80496,701795,867627,280988,465918,748627,321025,564279,79716,786173}, 23);  // 83
        System.out.println(sum);
    }
}
