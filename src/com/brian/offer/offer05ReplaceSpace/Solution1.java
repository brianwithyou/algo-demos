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
public class Solution1 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] res = new char[3 * s.length()];
        int arrIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res[arrIdx] = '%';
                arrIdx++;
                res[arrIdx] = '2';
                arrIdx++;
                res[arrIdx] = '0';
                arrIdx++;
            } else {
                res[arrIdx] = s.charAt(i);
                arrIdx++;
            }
        }
        // 也可以使用这个构造函数创建
//        String newStr = new String(res, 0, arrIdx);
//        return newStr;

        char[] result = new char[arrIdx];
        // 可以使用copy函数
//        System.arraycopy(res, 0, result, 0, arrIdx - 1);
        for (int i = 0; i < arrIdx; i++) {
            result[i] = res[i];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = new Solution1().replaceSpace("We are happy.");
        System.out.println(s);
    }
}
