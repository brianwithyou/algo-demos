package com.brian.leet2404MostFrequentEvenElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 *
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 *
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 *
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 *
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 *
 * 链接：https://leetcode.cn/problems/most-frequent-even-element
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int mostFrequentEven(int[] nums) {

        // 保存 nums[i] -> count
        Map<Integer, Integer> map = new HashMap<>();
        // 保存 result  nums[i] -> count
        int[] res = new int[]{-1, 0};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

                if (map.get(nums[i]) > res[1]) {
                    res[0] = nums[i];
                    res[1] = map.get(nums[i]);
                } else if (map.get(nums[i]) == res[1]) {
                    // 如果存在多个满足条件的元素
                    res[0] = Math.min(res[0], nums[i]);
                }
            }

        }
        return res[0];
    }

    public static void main(String[] args) {
        int[] data = {8154, 9139, 8194, 3346, 5450, 9190, 133, 8239, 4606, 8671, 8412, 6290}; // 3346
        int i = new Solution().mostFrequentEven(data);
        System.out.println(i);
    }

}
