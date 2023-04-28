package com.brian.offer.offer17printNumbers;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int[] printNumbers(int n) {

        int total = (int) (Math.pow(10, n) - 1);
        int[] res = new int[total];
        for (int i = 0; i < total; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
