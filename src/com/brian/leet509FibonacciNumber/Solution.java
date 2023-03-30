package com.brian.leet509FibonacciNumber;

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
public class Solution {

    /**
     * 递归
     */
    public int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);

    }

    public static void main(String[] args) {
        int fib = new Solution().fib(4);
        System.out.println(fib);
    }
}
