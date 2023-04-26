package com.brian.leet50MyPow;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 链接：https://leetcode.cn/problems/powx-n
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / myPow(x, (long)-n);
        }

        double y = myPow(x, (long)n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * n过大时，栈溢出，需要转成long
     */
    public double myPow(double x, long n) {
        if (n == 0)
            return 1.0;

        double y = myPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
//    public double myPow(double x, int n) {
//        long N = n;
//        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
//    }
//
//    public double quickMul(double x, long N) {
//        if (N == 0) {
//            return 1.0;
//        }
//        double y = quickMul(x, N / 2);
//        return N % 2 == 0 ? y * y : y * y * x;
//    }

    public static void main(String[] args) {
//        double v = new Solution().myPow(2.1, 3);
//        double v = new Solution().myPow(1.0, -2147483648);
        double v = new Solution().myPow(2.0, -2147483648);
        System.out.println(v);

    }
}
