package com.brian.leet350IntersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n ;i++) {
            if (map1.containsKey(nums2[i])) {
                res.add(nums2[i]);
                map1.put(nums2[i], map1.get(nums2[i]) - 1);
                if (map1.get(nums2[i]) == 0) {
                    map1.remove(nums2[i]);
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
