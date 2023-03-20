package com.brian.leet03lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author : Brian
 * @since 0.1
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int res = 0;
        int rightIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightIdx + 1 < s.length() && !set.contains(s.charAt(rightIdx + 1))) {
                set.add(s.charAt(rightIdx + 1));
                rightIdx++;
            }

            res = Math.max(res, rightIdx - i + 1);
        }
        return res;
    }

    /**
     *     for循环内是右侧指针，思路是 右侧指针固定，左侧指针变动，
     *     上面的方法是 左侧指针固定 右侧指针变动
     *     也能用动态规划 可以练习动态规划
     *     【不能用动态规划，dp[i]如果表示以第i个元素结尾的最大长度，i+1时用不上这个最优子结构，因为以i结尾的最大长度可能不是连续的】
     *     【dp[i]如果表示以第i个元素结尾的连续长度，则仍然需要两个指针（两层循环）】
     *
     *     下面的方法不容易理解，abort
     */
    public int lengthOfLongestSubstring2(String s) {

        if (s .length() == 0) {
            return 0;
        }
        int res = 0;
        // left 滑动窗口最左侧，取值逻辑为已存在元素的最右侧那个 与 原来left的max，解决 abca(left = 1)和 abba(left = 2)两种问题
        int left  = 0;
        // 存放滑动窗口的左边界指针
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 解决 abca  abba的两种情况
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
            System.out.println(res);
        }
        return res;

    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
