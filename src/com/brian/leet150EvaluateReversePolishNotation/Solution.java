package com.brian.leet150EvaluateReversePolishNotation;

import java.util.*;

/**
 * 150. 逆波兰表达式求值
 * Evaluate Reverse Polish Notation 【notation: 符号】
 * 给你一个字符串数组 tokens ，表示一个根据逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<String> operators = new ArrayList<>() {{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (operators.contains(token)) {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();
                switch (token) {
                    case "+":
                        // 顺序不能反了，后弹出的在前边
                        stack.push(pop2 + pop1);
                        break;
                    case "-":
                        // 顺序不能反了，后弹出的在前边
                        stack.push(pop2 - pop1);
                        break;
                    case "*":
                        stack.push(pop2 * pop1);
                        break;
                    case "/":
                        stack.push(pop2 / pop1);
                        break;
                    default:
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        int i = new Solution().evalRPN(new String[]{"2", "1", "+", "3", "*"}); // 9
        int i = new Solution().evalRPN(new String[]{"4","13","5","/","+"}); // 6
        System.out.println(i);
    }
}
