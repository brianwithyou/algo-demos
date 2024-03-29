package com.brian.leet17LetterCombinationsPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    String[] letterDict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 自顶向下  还是自底向上？怎么判断
     * 两种方法都可以解决问题
     * 1. 递归函数有返回值，可以自底向上，2. 递归函数没有返回值，可以使用外层递归构建的值当做param传进递归函数中(函数形参需要加入这个param)。
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        findCombination(res, digits, 0, "");
        return res;
    }

    private void findCombination(List<String> result, String digits, int index, String tempStr) {
        if (index == digits.length()) {
            result.add(tempStr);
            return;
        }
        if (digits.charAt(index) <= '1' || digits.charAt(index) > '9') {
            throw new RuntimeException("输入不合法");
        }

        // abc
        String str = letterDict[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            // 注意传入的tempStr是个新的字符串，就不需要还原此次的修改，如果传入的是同一个字符串，则需要还原此次修改
            findCombination(result, digits, index + 1, tempStr + str.charAt(i));
            // 传入上次传入的字符串时，需要还原此次的取值，应该这么写
//            tempStr = tempStr + str.charAt(i);
//            findCombination(result, digits, index + 1, tempStr);
//            tempStr = tempStr.substring(0, tempStr.length() - 1);

        }
    }
}
