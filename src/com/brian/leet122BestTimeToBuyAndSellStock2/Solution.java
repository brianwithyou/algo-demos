package com.brian.leet122BestTimeToBuyAndSellStock2;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润。
 * <p>
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 总利润为 4 。
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。
 * <p>
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 不放过每一个赚钱的机会，反正可以卖了接着买入
     *
     * 贪心算法，感觉不太通用，因为其他的题目没法用贪心
     */
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                res += (prices[i] - prices[i - 1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] data = new int[]{7,1,5,3,6,4};
        int[] data = new int[]{7,6,5,4,1};
        int maxProfit = new Solution().maxProfit(data);
        System.out.println(maxProfit);
    }
}
