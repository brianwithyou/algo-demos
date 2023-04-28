package com.brian.leet154FindMinimumInRotatedSortedArray2;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须尽可能减少整个过程的操作步骤。
 * <p>
 * 输入：nums = [1,3,5]
 * 输出：1
 * <p>
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {    // nums[mid] == nums[right]
                // 说明[mid, right]都是一样的数值，从左半部分找，需要包含mid处，因为可能后半部分都是最小的
                // 3, 3, 1, 3, 不能只从左半部分找，也可能在有半部分
//                right = mid;
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
//        int min = new Solution().findMin(new int[]{2, 2, 2, 0, 1});
//        int min = new Solution().findMin(new int[]{2, 2, 2, 2, 2});
        int min = new Solution().findMin(new int[]{3, 3, 1, 3});
        System.out.println(min);
    }

}
