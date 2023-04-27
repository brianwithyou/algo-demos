package com.brian.offer.offer31validateStackSequences;

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
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

//        boolean b = new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});  // true
        boolean b = new Solution().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});  // false
        System.out.println(b);
    }
}
