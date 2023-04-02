package com.brian.leet343IntegerBreak;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 2 <= n <= 58
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1_MemorySearch {

    int[] memory;
    public int integerBreak(int n) {
        memory = new int[n + 1];
        return doBreak(n);
    }
    public int doBreak(int n) {
        if (n == 1)
            return 1;

        if (memory[n] != 0) {
            return memory[n];
        }

        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max3(res, i * (n - i), i * doBreak(n - i));
        }
        memory[n] = res;

        return res;
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    public static void main(String[] args) {
        int i = new Solution1_MemorySearch().integerBreak(10);
        System.out.println(i);
    }
}

