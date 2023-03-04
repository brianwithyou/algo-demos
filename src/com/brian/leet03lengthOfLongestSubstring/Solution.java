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
        // rightIdx = -1 时， result = Math.max(result, rightIdx - i + 1);
        int rightIdx = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightIdx < s.length() && !set.contains(s.charAt(rightIdx))) {
                set.add(s.charAt(rightIdx));
                rightIdx++;
            }
            result = Math.max(result, rightIdx - i);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {

        if (s .length() == 0) {
            return 0;
        }
        int res = 0;
        // left 为最右边的那个元素索引
        int left  = 0;
        // 存放滑动窗口的左边界指针
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
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
