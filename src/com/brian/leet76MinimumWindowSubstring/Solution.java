package com.brian.leet76MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * 链接：https://leetcode.cn/problems/minimum-window-substring
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public String minWindow(String s, String t) {

        // [left, right]
        int left = 0, right = -1;
        String result = s + "a";
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (left <= s.length() - t.length()) {
            if (right - left + 1 < t.length()) {
                right++;
                sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0) + 1);
            } else {
                if (isCovered(sCount, tCount)) {
                    result = (right - left + 1 < result.length()) ? s.substring(left, right + 1) : result;

                    sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);
                    left++;

                } else {
                    if (right + 1 < s.length()) {
                        right++;
                        sCount.put(s.charAt(right), sCount.getOrDefault(s.charAt(right), 0 ) + 1);
                    } else {
                        sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);
                        left++;
                    }
                }
            }
        }

        return result.length() == s.length() + 1 ? "" : result;
    }

    public boolean isCovered(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        Iterator<Map.Entry<Character, Integer>> iterator = tCount.entrySet().iterator();

        while (iterator.hasNext())  {
            Map.Entry<Character, Integer> next1 = iterator.next();
            if (sCount.getOrDefault(next1.getKey(), 0) < next1.getValue()) {
                return false;
            }
        }
        return true;
    }
    /**
     * 因为字符串过长会超出时间限制，所以需要维护一个hashMap
     */
    public boolean isCovered(String s, String t) {
        if (s.length() < t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean covered = new Solution().isCovered("abcdde", "abf");
//        String s = new Solution().minWindow("ADOBECODEBANC", "ABC");
//        String s = new Solution().minWindow("ABC", "B");
        String s = new Solution().minWindow("A", "AA");

//        String s = new Solution().minWindow("ABC", "B");
        System.out.println(s);
    }
}
