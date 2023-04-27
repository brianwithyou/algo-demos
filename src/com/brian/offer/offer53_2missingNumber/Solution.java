package com.brian.offer.offer53_2missingNumber;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 *
 * 1 <= 数组长度 <= 10000
 *
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int missingNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
//        int i = new Solution().missingNumber(new int[]{0, 1, 3});
//        int i = new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9});
        int i = new Solution().missingNumber(new int[]{0});
        System.out.println(i);
    }
}
