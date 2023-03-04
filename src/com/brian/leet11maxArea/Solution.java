package com.brian.leet11maxArea;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * @author : Brian
 * @since 0.1
 */
public class Solution {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // res = 49
        int[] data = new int[] {1,8,6,2,5,4,8,3,7};
        
        Solution solution = new Solution();
        int i = solution.maxArea(data);
        System.out.println(i);
    }

}
