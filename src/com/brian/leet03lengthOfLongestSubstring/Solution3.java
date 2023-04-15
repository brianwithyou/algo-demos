package com.brian.leet03lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 【重点】跟第209题一起看，滑动窗口只需要一次while循环，条件是left指针到length，while内只需要if判断即可
 *
 * @author : Brian
 * @since 0.1
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = -1;

        int res = 0;

        Set<Character> set = new HashSet<>();
        // 方案1  每次循环，左指针不一定+1，
        while (left < s.length()) {
            if (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
                res = Math.max(res, right - left + 1);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        // 方案2  每次循环，左指针都+1，所以for循环内必须一次就找到i位置时的max result
//        int right = -1;
//        int res = 0;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (i != 0) {
//                set.remove(s.charAt(i - 1));
//            }
//
//            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
//                right++;
//                set.add(s.charAt(right));
//            }
//            res = Math.max(res, right - i + 1);
//        }

        return res;
    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        Solution3 solution = new Solution3();
        int i = solution.lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
