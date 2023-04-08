package com.brian.leet136SingleNumber;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 *
 * 链接：https://leetcode.cn/problems/single-number
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            // 异或运算，a^a = 0
            single = single ^ nums[i];
        }
        return single;

    }
}
