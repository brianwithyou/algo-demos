package com.brian.leet04MedianOfTwoSortedArrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * O(m+n)
     * O(m+n)
     * 可优化为 O(m+n)  O(1)
     *
     * 二分搜索法，可优化为 O(log(m+n)) O(1)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        // 奇数个时， midIdx = total / 2; 向下取整，偶数个时，total / 2 与 (total / 2) - 1 取平均
        int[] nums = new int[total];

        int cur1 = 0;
        int cur2 = 0;
        int i = 0;
        while (cur1 < m || cur2 < n) {
            if (cur1 >= m) {
                nums[i] = nums2[cur2];
                i++;
                cur2++;
                continue;
            }
            if (cur2 >= n) {
                nums[i] = nums1[cur1];
                i++;
                cur1++;
                continue;
            }
            if (nums1[cur1] < nums2[cur2]) {
                nums[i] = nums1[cur1];
                i++;
                cur1++;
            } else {
                nums[i] = nums2[cur2];
                cur2++;
                i++;
            }
        }
        if (total % 2 == 1) {
            return nums[total/2] * 1.0;
        }
        return (nums[total / 2] + nums[total / 2 - 1]) / 2.0;
    }

    public static void main(String[] args) {
//        double medianSortedArrays = new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        double medianSortedArrays = new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4});
        System.out.println(medianSortedArrays);
    }
}
