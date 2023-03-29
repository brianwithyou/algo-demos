package com.brian.leet47Permutations2;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        permuteUnique(nums, new ArrayList<>(), 0);
        return res;
    }
    public void permuteUnique(int[] nums, List<Integer> ans, int index) {
        if (index == nums.length) {
            res.add(new ArrayList<>(ans));
            return;
        }
        Set<Integer> usedSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!used[i] && !usedSet.contains(nums[i])) {
//            if (!used[i]) {
                usedSet.add(nums[i]);
                used[i] = true;
                ans.add(nums[i]);
                permuteUnique(nums, ans, index + 1);
                used[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 1, 2});
//        List<List<Integer>> lists = new Solution().permuteUnique(new int[]{1, 2, 3});
        System.out.println(lists);
    }

}
