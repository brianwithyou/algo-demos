package com.brian.leet946ValidateStackSequences;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();

        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            // 同时出栈
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
