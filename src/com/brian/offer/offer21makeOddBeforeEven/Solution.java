package com.brian.offer.offer21makeOddBeforeEven;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4] 
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 *
 * 链接：https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 *
 * time complexity O(n)
 * space complexity O(1)
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int[] exchange(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int oddIdx = 0;
        int evenIdx = nums.length - 1;
        while (oddIdx < evenIdx) {
            if (nums[oddIdx] % 2 == 0) {
                swap(nums, oddIdx, evenIdx);
                evenIdx--;
            } else {
                oddIdx++;
            }
        }
        return nums;
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] exchange = new Solution().exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(exchange));
    }
}
