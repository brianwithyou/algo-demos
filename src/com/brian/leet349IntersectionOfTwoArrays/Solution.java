package com.brian.leet349IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }

        return resSet.stream().mapToInt(i -> i).toArray();
    }

}
