package com.brian.leet.leet0000.leet11ContainerWithMostWater;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 *
 * @author Brian
 * @date 2023/6/8
 **/
public class Solution {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;

        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
    }
}
