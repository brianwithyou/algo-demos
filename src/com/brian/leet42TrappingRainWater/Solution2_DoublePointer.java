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
public class Solution2_DoublePointer {

    /**
     *
     */
    public int trap(int[] height) {

        int leftIdx = 0, rightIdx = height.length - 1;
        int leftMax = 0, rightMax = 0;

        int res = 0;
        while (leftIdx < rightIdx) {
            leftMax = Math.max(leftMax, height[leftIdx]);
            rightMax = Math.max(rightMax, height[leftIdx]);

            if (height[leftIdx] < height[rightIdx]) {
                res = res + leftMax - height[leftIdx];
                leftIdx++;
            } else {
                res = res + rightMax - height[rightIdx];
                rightIdx--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int trap = new Solution2_DoublePointer().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
//        int trap = new Solution2_DoublePointer().trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
