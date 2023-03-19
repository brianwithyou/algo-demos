package com.brian.leet75SortColors;

/**
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {

    /**
     * 三路快排方案
     */
    public void sortColors(int[] nums) {

        // [0, zero] 全为0， [two, length - 1]全为2， 中间的都是1
        int zero = -1;
        int two = nums.length;

        // 注意结尾条件
        for (int i= 0; i < two;) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 1){
                i++;
            } else {
                assert nums[i] == 2;
                two--;
                swap(nums, i, two);
            }
        }

    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] tem = new int[] {2,0,2,1,1,0};
        new Solution1().sortColors(tem);
    }
}
