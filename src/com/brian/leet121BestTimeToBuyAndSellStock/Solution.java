package com.brian.leet121BestTimeToBuyAndSellStock;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    /**
     * 动态规划
     */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        // 存放第i天卖出，获得的最大收益
        int[] dp = new int[prices.length];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            dp[i] = Math.max(0, prices[i] - minPrice);

            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
