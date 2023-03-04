package com.brian.leet14longestCommonPrefix;

/**
 * 
 * @author : Brian
 * @since 0.1
 */
public class Solution {

    /**
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */
    public String longestCommonPrefix2String(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int minLen = Math.min(length1, length2);
        if (minLen == 0) {
            return "";
        }

        int idx = 0;
        while (idx < minLen && str1.charAt(idx) == str2.charAt(idx)) {
            idx++;
        }
        return str1.substring(0, idx);
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix2String(prefix, strs[i]);
        }
        return prefix;

    }

    public static void main(String[] args) {
        String data = "abacd";
        String data2 = "abck";

        Solution solution = new Solution();
        String s = solution.longestCommonPrefix2String(data, data2);
        System.out.println(s);
        System.out.println(data.substring(0, 4));
    }


}
