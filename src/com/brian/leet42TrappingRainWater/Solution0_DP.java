package com.brian.leet42TrappingRainWater;

/**
 * 42.接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 链接：https://leetcode.cn/problems/trapping-rain-water
 * @author : brian
 * @since 0.1
 */
public class Solution0_DP {

    /**
     * 左侧max的dp记录  与 右侧max的dp记录  取重合的高度(左右两侧在i出的min值)相加(需要减去当前高度)，即为result
     */
    public int trap(int[] height) {

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int trap = new Solution_DP().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int trap = new Solution0_DP().trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
