package com.brian.offer.offer57twoSum;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * 
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i]<= 10^6
 *
 * 链接：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(target - nums[i])) {
                return new int[]{target - nums[i], nums[i]};
            } else {
                set.add(nums[i]);
            }
        }
        throw new RuntimeException("no solution.");
    }
}
