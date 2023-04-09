package com.brian.leet438FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 来源：力扣（LeetCode）
 *
 * @author : brian
 * @link <a href=https://leetcode.cn/problems/find-all-anagrams-in-a-string></a>
 * @since 0.1
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        int[] sCount = new int[26];

        // [left,right]
        int left = 0, right = -1;

        List<Integer> result = new ArrayList<>();
        while (left <= s.length() - p.length()) {
//            sCount[s.charAt(left) - 'a']++;

            if (isAnagram(sCount, pCount)) {
                result.add(left);
                sCount[s.charAt(left) - 'a']--;
                left++;
                if (right + 1 < s.length()) {
                    right++;
                    sCount[s.charAt(right) - 'a']++;
                }
            } else {
                if (right - left + 1 == p.length()) {
                    sCount[s.charAt(left) - 'a']--;
                    left++;
                    if (right + 1 < s.length()) {
                        right++;
                        sCount[s.charAt(right) - 'a']++;
                    }
                } else {
                    if (right + 1 < s.length()) {
                        right++;
                        sCount[s.charAt(right) - 'a']++;
                    }
                }
            }
        }
        return result;
    }

    public boolean isAnagram(int[] sCount, int[] pCount) {
        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != pCount[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "abcd";
//        String p = "cdba";
        // 0 6
        String s = "cbaebabacd";
        String p = "abc";

        // 0, 1, 2
//        String s = "abab";
//        String p = "ab";


//        boolean anagram = new Solution().isAnagram(s, p);
        List<Integer> anagrams = new Solution().findAnagrams(s, p);
        System.out.println(anagrams);
    }
}
