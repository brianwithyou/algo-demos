package com.brian.leet26RemoveDuplicatesFromSortedArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 26. 删除有序数组中的重复项
 * 返回数组的长度，超出长度的部分不需要考虑
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 借助额外空间
     */
    public int removeDuplicates(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }
        return temp.size();
    }

}
