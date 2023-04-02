package com.brian.leet120Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author : brian
 * @since 0.1
 */
public class Solution3_DP {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j < triangle.get(i - 1).size()) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + triangle.get(i).get(j));
                }
//                System.out.println(dp[i][j]);
            }
        }
        // 不能返回最后一个，因为只要到最后一层即可，遍历最后一层，取最小的
//        return dp[triangle.size() - 1][triangle.size() - 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[triangle.size() - 1].length; i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        // new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}}
        List<List<Integer>> data = new ArrayList<>() {{
            add(new ArrayList<>(){{add(2);}});
            add(new ArrayList<>(){{add(3);add(4);}});
            add(new ArrayList<>(){{add(6);add(5);add(7);}});
            add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
        }};
        int i = new Solution3_DP().minimumTotal(data);
        System.out.println(i);
    }

}
