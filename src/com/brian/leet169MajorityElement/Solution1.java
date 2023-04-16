package com.brian.leet169MajorityElement;

/**
 * 169. 多数元素 【easy】
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 链接：https://leetcode.cn/problems/majority-element
 * @author : brian
 * @since 0.1
 */
public class Solution1 {
    /**
     * 方法五：Boyer-Moore 投票算法
     * 思路
     * 如果我们把众数记为+1，把其他数记为−1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     * 链接：https://leetcode.cn/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     *
     * 摩尔投票法(Boyer–Moore majority vote algorithm)出自论文，算法解决的问题是如何在任意多的候选人（选票无序），选出获得票数最多的那个。
     */
    public int majorityElement(int[] nums) {

        // 投票 poll  ballot voting
        int ballot = 0;
        int candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (ballot == 0) {
                candidate = nums[i];
            }
            ballot += (candidate == nums[i] ? 1 : -1);
        }
        return candidate;
    }
}
