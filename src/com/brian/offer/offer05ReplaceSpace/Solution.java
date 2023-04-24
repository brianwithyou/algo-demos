package com.brian.offer.offer05ReplaceSpace;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 0 <= s 的长度 <= 10000
 *
 * 链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        String s = new Solution().replaceSpace("We are happy.");
        System.out.println(s);
    }
}
