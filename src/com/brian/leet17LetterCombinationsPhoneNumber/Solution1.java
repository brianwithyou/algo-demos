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
public class Solution1 {

    String[] letterDict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    /**
     * 变量 path，递归函数中，需要使用外层递归的值，所以需要传递，递归用完a or b or c时，需要还原，path删除当前元素
     * res 递归函数结尾，需要添加进res，但是又不返回出来，所以需要成员变量，res如果返回出来，则可以在递归函数中new
     */
    public List<String> letterCombinations(String digits) {
        // 自顶向下
        letterCombinations1(digits, 0, "");
        return res;
    }

    public List<String> letterCombinations2(String digits) {
        // 自底向上
        return letterCombinations2(digits, 0);
    }

    /**
     * 自底向上，需要判断两种end条件，1. 递归超出1层时的返回值 2. 递归最后一层的返回值
     */
    public List<String> letterCombinations2(String digits, int index) {
        List<String> result = new ArrayList<>();
        // 1. 递归超出1层
        if (index == digits.length())
            return new ArrayList<>();
        // 递归最后一层
        if (index == digits.length() - 1) {
            String availableChars = letterDict[digits.charAt(index) - '0'];
            for (int j = 0; j < availableChars.length(); j++) {
                result.add(availableChars.charAt(j) + "");
            }
            return result;
        }

        List<String> subRes = letterCombinations2(digits, index + 1);
        String availableChars = letterDict[digits.charAt(index) - '0'];
        for (int i = 0; i < subRes.size(); i++) {
            for (int j = 0; j < availableChars.length(); j++) {
                result.add(availableChars.charAt(j) + subRes.get(i));
            }
        }
        return result;
    }

    /**
     * 自顶向下
     */
    private void letterCombinations1(String digits, int index, String tempRes) {

        if (index == digits.length()) {
            res.add(tempRes);
            return;
        }

        char c = digits.charAt(index);
        String str = letterDict[c - '0'];
        for (int i = 0; i < str.length(); i++) {
            tempRes = tempRes + str.charAt(i);
            letterCombinations1(digits, index + 1, tempRes);
            tempRes = tempRes.substring(0, tempRes.length() - 1);
//            letterCombinations1(digits, index + 1, tempRes + str.charAt(i));
        }
    }

    public static void main(String[] args) {
//        List<String> strings = new Solution1().letterCombinations("23");
        List<String> strings = new Solution1().letterCombinations2("23");
        System.out.println(strings);
    }

}
