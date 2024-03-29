package com.brian.leet1003CheckIfWordIsValidAfterSubstitutions;

/**
 * 1003. 检查替换后的词是否有效
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 * <p>
 * 输入：s = "aabcbc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "aabcbc"
 * 因此，"aabcbc" 有效。
 * <p>
 * 输入：s = "abcabcababcc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * 因此，"abcabcababcc" 有效。
 * <p>
 * 输入：s = "abccba"
 * 输出：false
 * 解释：执行操作无法得到 "abccba" 。
 * <p>
 * 1 <= s.length <= 2 * 104
 * s 由字母 'a'、'b' 和 'c' 组成
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 101ms
     * 判断 s能否由""不断添加"abc"获得
     */
    public boolean isValid(String s) {
        while (s.length() >= 3) {
            int abcIdx = s.indexOf("abc");
            if (abcIdx == -1)
                return false;

            s = s.substring(0, abcIdx) + s.substring(abcIdx + 3);
        }
        return s.length() == 0;
    }

    /**
     * 7ms
     */
    public boolean isValid1(String s) {
        while (s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        String data =  "aabcdcb";
        System.out.println(data.substring(0,data.indexOf("abc")));
        System.out.println(data.substring(data.indexOf("abc") + 3));
        System.out.println(new Solution().isValid1("aabcdcb"));
        System.out.println(new Solution().isValid1("aabcbc"));
        System.out.println(new Solution().isValid1("abcabcababcc"));
    }
}
