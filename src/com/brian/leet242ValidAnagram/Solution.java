package com.brian.leet242ValidAnagram;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 链接：https://leetcode.cn/problems/valid-anagram
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map1 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), map1.get(s.charAt(i)) + 1);
            } else {
                map1.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map1.containsKey(t.charAt(i))) {
                if (map1.get(t.charAt(i)) > 0) {
                    map1.put(t.charAt(i), map1.get(t.charAt(i)) - 1);
                    if (map1.get(t.charAt(i)) == 0)
                        map1.remove(t.charAt(i));
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        boolean anagram = new Solution().isAnagram("anagram", "nagaram"); // true
        boolean anagram = new Solution().isAnagram("rat", "car"); // false
        System.out.println(anagram);
    }
}
