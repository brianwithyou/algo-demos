package com.brian.offer.offer16myPow;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
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
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1.0 / myPow2(x, -n);

        return myPow2(x, n);
    }
    public double myPow2(double x, long n) {
        if (n == 0)
            return 1.0;

        double y = myPow2(x, n / 2);
        if (n % 2 == 0)
            return y * y;
        else
            return y * y * x;
    }

    public static void main(String[] args) {
//        double v = new Solution().myPow(2, 10);
        double v = new Solution().myPow(0.00001, 2147483647);
        System.out.println(v);
    }
}
