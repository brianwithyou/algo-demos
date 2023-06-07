package com.brian.leet.leet0000.leet128LongestConsecutiveSequence;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -10^9 <= nums[i] <= 10^9
 *
 * @author Brian
 * @date 2023/6/7
 **/
public class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestRes = 0;
        for (int num : nums) {

            if (!set.contains(num - 1)) {

                int temRes = 1;
                int curNum = num;
                while (set.contains(curNum + 1)) {
                    temRes++;
                    curNum = curNum + 1;
                }
                longestRes = Math.max(temRes, longestRes);
            }
        }
        return longestRes;
    }
}
