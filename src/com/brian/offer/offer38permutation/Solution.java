package com.brian.offer.offer38permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * "aab"
 * ["aba","aab","baa"]
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    Set<String> res = new HashSet<>();
    boolean[] used;
    public String[] permutation(String s) {
        used = new boolean[s.length()];
        permutation(s, 0, "");
        String[] result = new String[res.size()];
        return res.toArray(result);

    }
    public void permutation(String s, int index, String temp) {
        if (index == s.length()) {
            res.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                // code1 当前递归修改temp结果，递归结束需要恢复原状，也可以递归函数中新建一个，参考 code2
//                temp += s.charAt(i);
//                permutation(s, index + 1, temp);
//                temp = temp.substring(0, temp.length() - 1);

                // code2 调用递归时，新建个字符串就不用恢复 temp的值
                permutation(s, index + 1, temp + s.charAt(i));
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] abcs = new Solution().permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }
}
