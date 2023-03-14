package com.brian.leet283MoveZeroes;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 借助额外空间
     */
    public void moveZeroes(int[] nums) {
        int[] tem = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tem[index++] = nums[i];
            }
        }
        for (int i = 0; i < tem.length; i++) {
            nums[i] = tem[i];
        }
    }

}
