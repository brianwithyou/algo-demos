package com.brian.offer.offer58reverseWords;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 * <p>
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入: "a good  example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 链接：https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        int left = 0, right = s1.length - 1;

        while (left < right) {
            if ("".equals(s1[left].trim())) {
                left++;
                continue;
            }
            if ("".equals(s1[right].trim())) {
                right--;
                continue;
            }
            swap(s1, left, right);
            left++;
            right--;
        }
        return Arrays.stream(s1).filter(item -> !"".equals(item.trim())).collect(Collectors.joining(" "));
    }

    public void swap(String[] strings, int left, int right) {
        String temp = strings[left];
        strings[left] = strings[right];
        strings[right] = temp;
    }

    public static void main(String[] args) {
//        String solution = new Solution().reverseWords("the sky is blue");
//        String solution = new Solution().reverseWords("  hello world!  ");
        String solution = new Solution().reverseWords("a good   example");
        System.out.println(solution);
    }
}
