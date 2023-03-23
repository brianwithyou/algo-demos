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
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = -1;
        int res = 0;
        Set<Character> set = new HashSet<>();

        // abacdea
        while (left < s.length()) {
            if (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                right++;
                set.add(s.charAt(right));
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        Solution2 solution = new Solution2();
        int i = solution.lengthOfLongestSubstring(test);
        System.out.println(i);
    }
}
