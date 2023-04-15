package com.brian.leet713SubarrayProductLessThanK;

/**
 * 713. 乘积小于 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 *
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 *
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 *
 * 提示:
 * 1 <= nums.length <= 3 * 104
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 106
 *
 * 链接：https://leetcode.cn/problems/subarray-product-less-than-k
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int right = 0;
        int product = 1;

         // [10,5,2,6], k = 100  10 、
        // 两层循环，内部的循环 一次找到当次 循环的所有result, 然后+= res
        while (right < nums.length) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }
            res += (right - left + 1);
            right++;
        }

        // 以left 为指针 遍历 不好想 give up 放弃
//        while (left < nums.length) {
//            if (right + 1 < nums.length && product * nums[right + 1] < k) {
//                right++;
//                product *= nums[right];
//                res++;
//            } else {
//                if (nums[left] >= k) {
//                    left++;
//                    continue;
//                }
//                if (right < left) {
//                    right = left;
//                }
//                product = nums[left];
//                res += (right - left);
//                product /= nums[left];
//                left++;
//
//            }
//        }
        return res;
    }



    public static void main(String[] args) {
        int i = new Solution().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100);
//        int i = new Solution().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0);
//        int i = new Solution().numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19); // 18
//        int i = new Solution().numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0); // 0
//        int i = new Solution().numSubarrayProductLessThanK(new int[]{76,8,75,22}, 18); // 1
        System.out.println(i);
    }
}
