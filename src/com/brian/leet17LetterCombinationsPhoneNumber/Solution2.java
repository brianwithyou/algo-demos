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
public class Solution2 {

    String[] letterDict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    /**
     * 变量 path，递归函数中，需要使用外层递归的值，所以需要传递，递归用完a or b or c时，需要还原，path删除当前元素
     * res 递归函数结尾，需要添加进res，但是又不返回出来，所以需要成员变量，res如果返回出来，则可以在递归函数中new
     */
    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);
    }
    public List<String> letterCombinations(String digits, int index) {
        List<String> result = new ArrayList<>();
        if (index == digits.length())
            return new ArrayList<>();
        if (index == digits.length() - 1) {
            String availableChars = letterDict[digits.charAt(index) - '0'];
            for (int j = 0; j < availableChars.length(); j++) {
                result.add(availableChars.charAt(j) + "");
            }
            return result;
        }

        List<String> subRes = letterCombinations(digits, index + 1);
        String availableChars = letterDict[digits.charAt(index) - '0'];
        for (int i = 0; i < subRes.size(); i++) {
            for (int j = 0; j < availableChars.length(); j++) {
                result.add(availableChars.charAt(j) + subRes.get(i));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> strings = new Solution2().letterCombinations("23");
        System.out.println(strings);
    }

}
