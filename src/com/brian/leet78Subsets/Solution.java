package com.brian.leet78Subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums, 0, new LinkedList<>());
        return res;
    }
    public void subsets(int[] nums, int index, LinkedList<Integer> ans) {
        res.add(new ArrayList<>(ans));
        if (index == nums.length)
            return;

        for (int i = index; i < nums.length; i++) {
            ans.add(nums[i]);
            subsets(nums, i + 1, ans);
            ans.removeLast();
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> subsets = new Solution().subsets(nums);
        System.out.println(subsets);
    }
}
