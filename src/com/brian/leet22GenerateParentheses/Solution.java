package com.brian.leet22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 * 1 <= n <= 8
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, "");
        return res;
    }

    /**
     * 还需要 n 个括号
     * right >= left
     */
    public void generateParenthesis(int left, int right, String tempPath) {

        // 这两种结束条件都可以 结束条件1
        if (left == 0 && right == 0) {
            res.add(tempPath);
            return;
        }
        // 这两种结束条件都可以 结束条件2
//        if (left == 0 && right == 1) {
//            res.add(tempPath + ")");
//            return;
//        }
//        if (left == 1 && right == 1) {
//            res.add(tempPath + "()");
//            return;
//        }
        if (left == right) {
            generateParenthesis(left - 1, right, tempPath + "(");
        } else if (left < right) {
            if (left > 0) {
                generateParenthesis(left - 1, right, tempPath + "(");
            }
            generateParenthesis(left, right - 1, tempPath + ")");
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }
}
