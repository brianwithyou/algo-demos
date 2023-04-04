package com.brian.leet213HouseRobber2;

/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *
 * 链接：https://leetcode.cn/problems/house-robber-ii
 * @author : brian
 * @since 0.1
 */
public class Solution0_Recursion_timeout {

    public int rob(int[] nums) {
        // 由于只有3个数时，可以直接取第三个
        if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public int rob(int[] nums, int start, int end) {
        if (start >= nums.length) {
            return 0;
        }
        // 由于只有3个数时，可以直接取第三个
//        if (end - start == 2) {
//            return Math.max(Math.max(nums[start], nums[start + 1]), nums[start + 2]);
//        }

        int res = 0;
        if (start + 1 > end)
            return nums[start];
        if (start + 1 == end)
            return Math.max(nums[start], nums[start + 1]);

        if (start + 2 <= end) {
            res = Math.max(rob(nums, start + 1, end), nums[start] + rob(nums, start + 2, end));
        }
        return res;
    }

    public static void main(String[] args) {
//        int rob = new Solution().rob(new int[]{2, 3, 2}); // 3
//        int rob = new Solution().rob(new int[]{1, 2, 3}); // 3
//        int rob = new Solution().rob(new int[]{0}); // 0
//        int rob = new Solution().rob(new int[]{1, 2, 3, 1}); // 0
        int rob = new Solution0_Recursion_timeout().rob(new int[]{1,3,1,3,100}); // 103
        System.out.println(rob);
    }
}
