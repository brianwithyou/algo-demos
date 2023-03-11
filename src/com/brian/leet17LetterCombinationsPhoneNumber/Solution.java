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
            findCombination(result, digits, index + 1, tempStr + str.charAt(i));
        }
    }
}
