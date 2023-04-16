package com.brian.leet169MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素 【easy】
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 链接：https://leetcode.cn/problems/majority-element
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (count.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        throw new RuntimeException("There is no solution.");
    }
}
