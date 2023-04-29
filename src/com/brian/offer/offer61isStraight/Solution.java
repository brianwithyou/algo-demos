package com.brian.offer.offer61isStraight;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public boolean isStraight(int[] nums) {

        Arrays.sort(nums);
        // 0的数量，因为是多副牌，所以可能大于2
        int zeroIdx = 0;
        while (nums[zeroIdx] == 0) {
            zeroIdx++;
        }
        // 判断有没有重复值
        for (int i = zeroIdx; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return false;
        }
        // 计算gap
        int gap = 0;
        for (int i = zeroIdx; i < nums.length - 1; i++) {
            gap += (nums[i + 1] - nums[i] - 1);
        }

        return gap <= zeroIdx;
    }
}
