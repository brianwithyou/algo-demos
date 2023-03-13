package com.brian.leet131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        List<String> tempRes = new ArrayList<>();
        partition(s, 0, tempRes, res);

        return res;
    }

    public void partition(String s, int start, List<String> tempRes, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(tempRes));
            return;
        }

        // 循环： aab时， 可以取 a aa aab(剪枝)
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {

                tempRes.add(s.substring(start, i + 1));
                // 递归调用, 注意 start = i + 1
                partition(s, i + 1, tempRes, result);

                tempRes.remove(tempRes.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "aab";

        System.out.println(test.substring(0, 0));
        List<List<String>> partition = new Solution().partition(test);
        System.out.println(partition);
    }
}
