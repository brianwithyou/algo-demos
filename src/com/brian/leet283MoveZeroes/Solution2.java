package com.brian.leet283MoveZeroes;

/**
 * 比如说给你输入 nums = [0,1,4,0,2]，你的算法没有返回值，但是会把 nums 数组原地修改成 [1,4,2,0,0]。
 * @author : brian
 * @since 0.1
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
