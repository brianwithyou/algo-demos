package com.brian.leet397IntegerReplacement;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * 给定一个正整数n ，你可以做如下操作：
 *
 * 如果n是偶数，则用n / 2替换n 。
 * 如果n是奇数，则可以用n + 1或n - 1替换n 。
 * 返回 n变为 1 所需的 最小替换次数 。
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 *
 * 链接：https://leetcode.cn/problems/integer-replacement
 * 
 * @author : brian
 * @since 0.1
 */
public class Solution_dp {
    public int integerReplacement(int n) {
        // dp[n] = max(dp[n/2] + 1, dp[n+1])
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 0);
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp.put(i, 1 + dp.get(i / 2));
            } else {
                dp.put(i, 2 + Math.min(dp.get(i / 2), dp.get(i / 2 + 1)));
            }
//            System.out.printf("dp[%s] = %s\n", i, dp[i]);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
//        int i = new Solution().integerReplacement(8);
//        int i = new Solution_dp().integerReplacement(65535);
        int i = new Solution_dp().integerReplacement(10000000);
        System.out.println(i);
    }
}
