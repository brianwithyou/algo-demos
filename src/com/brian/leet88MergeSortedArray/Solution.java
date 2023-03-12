package com.brian.leet88MergeSortedArray;

/**
 * 合并两个有序数组
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 结果放入num1中
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] sorted = new int[nums1.length];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < sorted.length; i++) {
            // 边界 需要注意
            if (index2 == n || (index1 < m && nums1[index1] < nums2[index2])) {
                sorted[i] = nums1[index1];
                index1++;
            } else {
                sorted[i] = nums2[index2];
                index2++;
            }
        }
        for (int i = 0; i < sorted.length; i++) {
            nums1[i] = sorted[i];
        }

    }

    public static void main(String[] args) {

        int[] num1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] num2 = {2, 4, 6, 8};
        new Solution().merge(num1, 4, num2, 4);

        System.out.println();
    }
}
