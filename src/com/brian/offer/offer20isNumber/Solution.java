package com.brian.offer.offer20isNumber;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 * 若干空格
 * 一个小数或者整数
 * （可选）一个'e'或'E'，后面跟着一个整数
 *
 * 小数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 *
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * 
 * 输入：s = "0"
 * 输出：true
 *
 * 输入：s = "e"
 * 输出：false
 *
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 *
 * 输入：s = ".1"
 * 输出：true
 * 
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 *
 * 链接：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * @author : brian
 * @since 0.1
 */
public class Solution {
    // decimal 小数，  integer 整数
    public boolean isNumber(String s) {
        String trim = s.trim();
        if ("".equals(trim)) {
            return false;
        }
        trim = trim.toLowerCase();
        if (trim.startsWith("e") || trim.endsWith("e")) {
            return false;
        }
        if (!trim.contains("e")) {
            return isDecimal(trim) || isInteger(trim);
        }
        // e 在中间的情况
        String[] es = trim.split("e");
        // 6ee69 防止多个e的情况
        if (es.length > 2) {
            return false;
        }
        return (isDecimal(es[0]) || isInteger(es[0])) && isInteger(es[1]);
    }
    private int dotCount = 0;
    public boolean isDecimal(String s) {
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (".".equals(s) || s.length() == 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                dotCount++;
                if (dotCount > 1) {
                    return false;
                }
                if (i - 1 >= 0 && !isSingleDigit(s.charAt(i - 1))) {
                    return false;
                }
                if (i + 1 < s.length() && !isSingleDigit(s.charAt(i + 1))) {
                    return false;
                }
            } else if (!isSingleDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInteger(String s) {
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            // 也可以用set存起来0-9, 然后判断contains()
            if (!isSingleDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /**
     * 判断是否是个位数 0-9
     */
    private boolean isSingleDigit(char s) {
        return s >= '0' && s <= '9';
    }

    public static void main(String[] args) {
//        boolean e = new Solution().isNumber("e"); // false
//        boolean e = new Solution().isNumber("."); // false
//        boolean e = new Solution().isNumber("+.8"); // true
//        boolean e = new Solution().isNumber(" -."); // false
//        boolean e = new Solution().isNumber("+E3"); // false
        boolean e = new Solution().isNumber("6ee69"); // false
        System.out.println(e);
    }

}
