package com.brian.leet46Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author : brian
 * @since 0.1
 */
public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        return permute(nums, 0);
    }
    public List<List<Integer>> permute(int[] nums, int index) {
        // 自底向上，结束条件需要判断两种情况，1. 递归超出1层时的返回值，2.递归最后一层的返回值
        List<List<Integer>> result = new ArrayList<>();

        // 1. 超出时的返回值
        if (index == nums.length)
            return result;

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            used[i] = true;
            List<List<Integer>> innerRes = permute(nums, index + 1);
            used[i] = false;
            for (int j = 0; j < innerRes.size(); j++) {
                List<Integer> temAns = new ArrayList<>();
                temAns.add(nums[i]);
                temAns.addAll(innerRes.get(j));
                result.add(temAns);
            }
            // 2. 最后一层的返回值
            if (innerRes.size() == 0) {
                List<Integer> temAns = new ArrayList<>();
                temAns.add(nums[i]);
                result.add(temAns);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution2().permute(nums);
        System.out.println(permute);
    }


}
