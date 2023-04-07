package com.brian.leet20ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            }
            index++;

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new Solution().isValid("()");
        System.out.println(valid);
    }
}
