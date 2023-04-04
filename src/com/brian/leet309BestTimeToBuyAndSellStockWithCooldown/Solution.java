package com.brian.leet309BestTimeToBuyAndSellStockWithCooldown;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int res = 0;
        // dp[i]标识第i天卖出能获取的最大收益
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i], dp[i - 1]), prices[i] - prices[j] + (j - 2 >= 0 ? dp[j - 2] : 0));
            }
//            System.out.println(dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        int i = new Solution().maxProfit(new int[]{1, 2, 3, 0, 2});
//        int i = new Solution().maxProfit(new int[]{1});
//        int i = new Solution().maxProfit(new int[]{1, 4, 2});
        int i = new Solution().maxProfit(new int[]{1, 2, 4});
//        int i = new Solution().maxProfit(new int[]{6,1,3,2,4,7}); // 6
//        int i = new Solution().maxProfit(new int[]{6,1,6,4,3,0,2}); // 7
        System.out.println(i);
    }
}
