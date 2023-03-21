package com.brian.leet345ReverseVowelsOfString;

import java.util.*;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    Set<Character> vowels = new HashSet<>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public String reverseVowels(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!vowels.contains(s.charAt(left))) {
                left++;
                continue;
            }
            if (!vowels.contains(s.charAt(right))) {
                right--;
                continue;
            }
            swap(chars, left, right);
            left++;
            right--;
        }

        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char leftChar = chars[left];
        chars[left] = chars[right];
        chars[right] = leftChar;
    }
}
