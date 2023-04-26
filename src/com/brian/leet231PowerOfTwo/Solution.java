package com.brian.leet231PowerOfTwo;

/**
 * 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得n == 2 ^ x ，则认为 n 是 2 的幂次方。
 *
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 *
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 *
 * 输入：n = 3
 * 输出：false
 *
 * 输入：n = 4
 * 输出：true
 *
 * 输入：n = 5
 * 输出：false
 *
 * 链接：https://leetcode.cn/problems/power-of-two
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n/2);
    }

    public static void main(String[] args) {
        boolean powerOfTwo = new Solution().isPowerOfTwo(8);
        System.out.println(powerOfTwo);
    }
}
