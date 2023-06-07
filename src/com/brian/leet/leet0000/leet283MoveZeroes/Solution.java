package com.brian.leet.leet0000.leet283MoveZeroes;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * @author Brian
 * @date 2023/6/7
 **/
public class Solution {

    /**
     * 需要保证相对顺序，该方案不符合题意
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        int slow = 0;
        for (int i= 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
    /**
     * 需要保证相对顺序，该方案不符合题意
     * @param nums
     */
    public void moveZeroes1(int[] nums) {

        int left = 0, right = nums.length -1;

        while (left < right) {
            if (nums[left] == 0) {
                swap(nums, left, right);
                left++;
                right--;
            } else {
                left++;
            }
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
