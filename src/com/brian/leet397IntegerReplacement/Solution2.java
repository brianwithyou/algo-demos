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
public class Solution2 {
    Map<Integer, Integer> memory = new HashMap<>();
    public int integerReplacement(int n) {
        if (n == 1)
            return 0;

        if (!memory.containsKey(n)) {
            if (n % 2 == 0)
                memory.put(n, 1 + integerReplacement(n / 2));
            else
                memory.put(n, 2 + Math.min(integerReplacement(n / 2 + 1), integerReplacement(n / 2) ));
        }

        return memory.get(n);
    }
    public static void main(String[] args) {
//        int i = new Solution().integerReplacement(8);
//        int i = new Solution2().integerReplacement(65535); // 17
        int i = new Solution2().integerReplacement(2147483647); // 17
        int test = 2147483647;
        System.out.println(test);
        // 溢出了
        System.out.println(test + 1);
        System.out.println(i);
    }
}
