package com.brian.leet15threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *  你返回所有和为 0 且不重复的三元组。
 *  注意：答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 返回不重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int rightIdx = nums.length - 1;
            // 寻找target
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                while (j < rightIdx &&nums[j] + nums[rightIdx] > target) {
                    rightIdx--;
                }
                if (rightIdx == j) {
                    break;
                }
                if (nums[j] + nums[rightIdx] == target) {
                    List<Integer> list = new ArrayList<>(List.of(nums[i], nums[j], nums[rightIdx]));
                    res.add(list);
                }
            }
        }
        return res;
    }
}
