package com.brian.leet198HouseRobber;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * 链接：https://leetcode.cn/problems/house-robber
 * @author : brian
 * @since 0.1
 */
public class Solution1_MemoryRecursion {
    int[] memory;
    public int rob(int[] nums) {
        memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return rob(nums, 0);
    }
    public int rob(int[] nums, int index) {

        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        if (memory[index] != -1)
            return memory[index];

        if (index == nums.length - 1)
            return nums[index];
        if ( index == nums.length - 2) {
            return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        }

        memory[index] = Math.max(nums[index] + rob(nums, index + 2), rob(nums, index + 1));
        return memory[index];
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 1};
        int rob = new Solution1_MemoryRecursion().rob(data);
        System.out.println(rob);
    }
}
