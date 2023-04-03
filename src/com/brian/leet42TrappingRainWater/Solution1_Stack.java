package com.brian.leet42TrappingRainWater;

import java.util.ArrayDeque;
import java.util.Deque;

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
public class Solution1_Stack {

    /**
     * 单调递减栈，当下一个高度高于stackTop时，（min(下一个的高度，stack第二top高度) - 中间的高度）* 宽度 就是要添加的容量
     */
    public int trap(int[] height) {
        int length = height.length;
        // 存放单调递减栈的 索引
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // top是两个高度中间的高度
                Integer top = stack.pop();
                if (stack.isEmpty())
                    break;

                Integer lastLeft = stack.peek();
                int width = i - lastLeft - 1;
                // 需要减去中间柱子的高度
                int curHeight = Math.min(height[i], height[lastLeft]) - height[top];
                res = res + curHeight * width;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int trap = new Solution1_Stack().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int trap = new Solution1_Stack().trap(new int[]{4,2,0,3,2,5});
        System.out.println(trap);
    }
}
