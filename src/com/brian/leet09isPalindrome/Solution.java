package com.brian.leet09isPalindrome;

/**
 * @author : Brian
 * @since 0.1
 */
public class Solution {

    /**
     * 例如，121 是回文，而 123 不是。
     */
    public boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
