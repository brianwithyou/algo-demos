package com.brian.offer.offer39majorityElement;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 限制：
 * 1 <= 数组长度 <= 50000
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 摩尔投票
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int mainEle = nums[0];
        int vote = 1;
        for (int i = 1; i < nums.length; i++) {
            if (vote == 0) {
                mainEle = nums[i];
                vote++;
            }
            else
                if (nums[i] == mainEle)
                    vote++;
                else
                    vote--;
        }

        return mainEle;
    }

    public static void main(String[] args) {
        int i = new Solution().majorityElement(new int[]{10, 9, 9, 9, 10});
        System.out.println(i);
    }
}
