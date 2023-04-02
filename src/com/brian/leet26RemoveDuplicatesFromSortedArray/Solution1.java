package com.brian.leet26RemoveDuplicatesFromSortedArray;

/**
 * 26. 删除有序数组中的重复项
 * 返回数组的长度，超出长度的部分不需要考虑
 * 1, 1, 2, 3, 3
 * @author : brian
 * @since 0.1
 */
public class Solution1 {
    /**
     * labuladong
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
    
}
