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
public class Solution1 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];

        List<Integer> ans = new ArrayList<>();

        permute(nums, 0, used, ans);

        return res;
    }

    private void permute(int[] nums, int index, boolean[] used, List<Integer> ans) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                ans.add(nums[i]);
                used[i] = true;
                permute(nums, index + 1, used, ans);

                used[i] = false;
                ans.remove(ans.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution1().permute(nums);
        System.out.println(permute);
    }


}
