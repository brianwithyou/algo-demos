package com.brian.leet11maxArea;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * @author : Brian
 * @since 0.1
 */
public class Solution1 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            } else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // res = 49
        int[] data = new int[] {1,8,6,2,5,4,8,3,7};
        
        Solution1 solution = new Solution1();
        int i = solution.maxArea(data);
        System.out.println(i);
    }

}
