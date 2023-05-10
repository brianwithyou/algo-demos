package com.brian.leet.leet1000.leet1015SmallestIntegerDivisibleByK;

import java.util.HashSet;
import java.util.Set;

/**
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 * <p>
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 * <p>
 * 注意： n 不符合 64 位带符号整数。
 * <p>
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * <p>
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * <p>
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 * <p>
 * 1 <= k <= 10^5
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int smallestRepunitDivByK(int k) {
        int resid = 1 % k, len = 1; // resid为余数，len为数字长度，初始值为1
        Set<Integer> set = new HashSet<Integer>(); // 创建一个无序集合，用于存储余数
        set.add(resid); // 插入余数1
        while (resid != 0) { // 当余数为0时退出循环
            resid = (resid * 10 + 1) % k; // 计算下一个余数
            len++; // 数字长度+1
            if (set.contains(resid)) { // 如果余数重复出现，则无解
                return -1;
            }
            set.add(resid); // 将余数插入集合
        }
        return len; // 返回数字长度
    }
}
