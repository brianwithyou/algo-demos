package com.brian.offer.offer58reverseLeftWords;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 * <p>
 * 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++)
            res.append(s.charAt(i));
        for (int i = 0; i < n; i++)
            res.append(s.charAt(i));

        // 利用求余运算，可以简化代码。
//        for (int i = n; i < n + s.length(); i++)
//            res.append(s.charAt(i % s.length()));

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().reverseLeftWords("hello", 2));
    }
}
