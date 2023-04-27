package com.brian.offer.offer53CountTargetInArray;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109<= nums[i]<= 109
 * nums是一个非递减数组
 * -109<= target<= 109
 *
 * 链接：https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 找到结果，中心扩展
                int l = mid - 1, r = mid + 1;
                while (l >= 0 && nums[l] == target) {
                    l--;
                }
                while (r < nums.length && nums[r] == target) {
                    r++;
                }
                res =  r - l - 1;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int search = new Solution().search(new int[]{5, 7, 7, 8, 8, 8, 8, 10}, 8);
        int search = new Solution().search(new int[]{1}, 1);
        System.out.println(search);
    }

}
