package com.brian.leet39CombinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * <p>
 * 链接：https://leetcode.cn/problems/combination-sum
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void combinationSum(int[] candidates, int target, int index, List<Integer> ans) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        // 由于下一次递归index还可以是本身(可以重复使用)，所以不能用index和长度判断结尾
//        if (index == candidates.length) {
//            return;
//        }

        for (int i = index; i < candidates.length; i++) {
            ans.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }

}
