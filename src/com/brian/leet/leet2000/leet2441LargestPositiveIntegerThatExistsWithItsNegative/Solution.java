package com.brian.leet.leet2000.leet2441LargestPositiveIntegerThatExistsWithItsNegative;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441. 与对应负数同时存在的最大正整数
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 * 返回正整数 k ，如果不存在这样的整数，返回 -1 。
 *
 * 输入：nums = [-1,2,-3,3]
 * 输出：3
 * 解释：3 是数组中唯一一个满足题目要求的 k 。
 *
 * 输入：nums = [-1,10,6,7,-7,1]
 * 输出：7
 * 解释：数组中存在 1 和 7 对应的负数，7 的值更大。
 *
 * 输入：nums = [-10,8,6,7,-2,-3]
 * 输出：-1
 * 解释：不存在满足题目要求的 k ，返回 -1 。
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int findMaxK(int[] nums) {

        Set<Integer> count = new HashSet<>();
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (count.contains(-nums[i])) {
                res = Math.max(Math.abs(nums[i]), res);
            } else {
                count.add(nums[i]);
            }
        }
        return res;
    }
}
