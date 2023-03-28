package com.brian.leet77Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 1234
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 * c(4, 3) = 123, 124, 134, 234
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        return combine(n, k, 0);
    }

    /**
     * 自底向上的递归，先递归，然后使用递归返回值
     * Solution2是自顶向下的递归，先使用当前值，组装数据，内层传递
     */
    public List<List<Integer>> combine(int n, int k, int index) {
        List<List<Integer>> ans = new ArrayList<>();
        // 超出1层
        if (k < 1) {
            return ans;
        }
        // 最后一层，由于最后一层可以取多个，所以不能用if，在下面的for循环中return
        if (k == 1) {
            for (int j = index + 1; j <= n; j++) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(j);
                ans.add(subRes);
            }
            return ans;
        }
        // 由于k <= n 所以由n判断的end条件，不需要判断了
        // 递归超出1层
//        if (index == n + 1) {
//            return ans;
//        }
//        // 递归最后一层
//        if (index == n) {
//            List<Integer> subAns = new ArrayList<>();
//            subAns.add(index);
//            ans.add(subAns);
//            return ans;
//        }

        for (int i= index + 1; i < n; i++) {
            List<List<Integer>> innerRes = combine(n, k - 1, i);
            for (int j = 0; j < innerRes.size(); j++) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(i);
                subRes.addAll(innerRes.get(j));
                ans.add(subRes);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(4, 2);
        System.out.println(combine);
    }
}
