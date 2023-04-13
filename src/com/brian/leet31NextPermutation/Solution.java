package com.brian.leet31NextPermutation;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 链接：https://leetcode.cn/problems/next-permutation
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i > 0 && nums[i - 1] < nums[i]) {
                int minGreater = nums[i];
                int idx = i;
                int minGreaterIdx = i;

                while (idx < nums.length) {
                    if (nums[idx] > nums[i - 1]) {
                        minGreater = Math.min(minGreater, nums[idx]);
                        minGreaterIdx = idx;
                    }
                    idx++;
                }
                swap(nums, i - 1, minGreaterIdx);
                reverse(nums, i, nums.length - 1);
                break;
            }
            if (i == 0) {
                reverse(nums, 0, nums.length - 1);
            }
        }
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int minGreaterIdx) {
        int temp = nums[i];
        nums[i] = nums[minGreaterIdx];
        nums[minGreaterIdx] = temp;
    }

    public static void main(String[] args) {
//        int[] data = new int[]{1, 2, 3};
//        int[] data = new int[]{3, 2, 1};
        int[] data = new int[]{1, 1, 5};
        new Solution().nextPermutation(data);
        System.out.println(Arrays.toString(data));
    }
}
