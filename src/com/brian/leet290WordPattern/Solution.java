package com.brian.leet290WordPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 *
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 * 链接：https://leetcode.cn/problems/word-pattern
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length)
            return false;

        Map<Character, String> char2Str = new HashMap<>();
        Map<String, Character> str2Char = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            if (char2Str.containsKey(pattern.charAt(i)) && !char2Str.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }
            if (str2Char.containsKey(words[i]) && !str2Char.get(words[i]).equals(pattern.charAt(i))) {
                return false;
            }

            char2Str.put(pattern.charAt(i), words[i]);
            str2Char.put(words[i], pattern.charAt(i));
        }
        return true;
    }
}
