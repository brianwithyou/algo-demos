package com.brian.leet216CombinationSum3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 *
 * 链接：{ <a href="https://leetcode.cn/problems/combination-sum-iii">...</a>}
 * @author : brian
 * @since 0.1
 */
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3(k, n, 1, new LinkedList<>());
        return res;
    }
    public void combinationSum3(int k, int n, int index, LinkedList<Integer> ans) {
        System.out.printf("%s个元素和为%s, 当前元素%s, 当前答案池%s\n", k, n, index, ans);
        if (0 == k && n == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        if (k < 0) {
            return;
        }
        if (n < 0)
            return;
        // 剪枝，从大于index的数中找一个小于index的，已经不可能了
        if (n < index) {
            return;
        }
        // 还能继续剪枝，待优化

        for (int i = index;i <= 9; i++) {
            ans.add(i);
            combinationSum3(k - 1, n - i, i + 1, ans);
            ans.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum3(3, 7);
        System.out.println(lists);
    }
}
