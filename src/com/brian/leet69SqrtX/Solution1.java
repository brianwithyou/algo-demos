package com.brian.leet69SqrtX;

/**
 * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. 
 * The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * 链接：https://leetcode.cn/problems/sqrtx
 * 
 * @author : brian
 * @since 0.1
 */
public class Solution1 {
    // ans * ans <= x
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid == x)
                return mid;
            if ((long)mid * mid < x) {
//                if (((mid + 1) ^ 2) > x) { // ^不是平方符号
                if ((long) (mid + 1) * (mid + 1) > x) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new RuntimeException("no solution.");
    }

    public static void main(String[] args) {
        int i = new Solution1().mySqrt(8);
        System.out.println(i);
    }
}
