package com.brian.leet205IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 *
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        // 这4个for循环可以放入 同一个for循环中，只需要遍历一次即可
        Map<Character, Character> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), t.charAt(i));
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(map1.get(s.charAt(i)));
        }

        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map2.put(t.charAt(i), s.charAt(i));
        }

        StringBuilder res2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res2.append(map2.get(t.charAt(i)));
        }

        return res.toString().equals(t) && res2.toString().equals(s);
    }

    public static void main(String[] args) {
//        boolean isomorphic = new Solution().isIsomorphic("egg", "add"); // true
//        boolean isomorphic = new Solution().isIsomorphic("paper", "title"); // true
        boolean isomorphic = new Solution().isIsomorphic("badc", "baba"); // false
        System.out.println(isomorphic);
    }
}
