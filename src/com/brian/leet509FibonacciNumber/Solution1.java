package com.brian.leet509FibonacciNumber;

import java.util.Arrays;

/**
 * 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。该数列由0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1)= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 *
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 *
 * 链接：https://leetcode.cn/problems/fibonacci-number
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    int[] memo;
    /**
     * 记忆化搜索
     */
    public int fib(int n) {
        memo = new int[n + 1];
        return fibo(n);
    }
    public int fibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (memo[n] == 0)
            memo[n] = fibo(n - 1) + fibo(n - 2);

        return memo[n];
    }

    public static void main(String[] args) {
        int fib = new Solution1().fib(4);
        System.out.println(fib);
    }
}
