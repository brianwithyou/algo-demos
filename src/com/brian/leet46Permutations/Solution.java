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
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        permute(nums, 0, used, ans, res);

        return res;
    }

    /**
     *
     * @param index index只是用于记录是否结束
     */
    public void permute(int[] nums, int index, boolean[] used, List<Integer> ans, List<List<Integer>> res) {
        if (index == nums.length) {
            // 注意 这里只能是新建一个对象
            res.add(new ArrayList<>(ans));
            return;
        }
        // 需要辅助结构判断数是否已经被使用
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                ans.add(nums[i]);
                used[i] = true;
                // 递归计算后面的，递归完成会返回这里，此时已经取回一种结果，需要把used状态恢复
                permute(nums, index + 1, used, ans, res);

                used[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution().permute(nums);
        System.out.println(permute);
    }



}
