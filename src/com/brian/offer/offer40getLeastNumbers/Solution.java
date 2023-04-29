package com.brian.offer.offer40getLeastNumbers;

import java.util.Arrays;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] min = new int[k];
        Arrays.sort(arr);
        for(int i = 0;i<k;++i) min[i] = arr[i];
        return min;
    }
}
