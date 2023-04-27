package com.brian.offer.offer03findRepeatNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        throw new RuntimeException("no solution.");
    }
}
