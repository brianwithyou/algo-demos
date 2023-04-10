package com.brian.leet912SortAnArray;

import java.util.Arrays;

/**
 * 手撕快速排序、归并排序、堆排序
 * pivot
 * 美[ˈpɪvət] 英['pɪvət]
 * n.支点；枢轴；中心；中心点
 * @author : brian
 * @since 0.1
 */
public class Solution3_3Ways {

    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 优化1：随机化pivot
     * 优化2：三路快排，partition操作无法返回中间指针(需要返回smaller和greater两个返回值)，所以partition操作写在主函数体内了
     */
    public void sortArray(int[] nums, int left, int right) {
        if (left >= right)
            return;

        // 【优化1】随机化pivot，在 近乎有序的数组中 加快排序速度
        int random = (int) (left + (right - left) * Math.random());
        swap(nums, left, random);
        int pivot = nums[left];

        int smaller = left;
        int greater = right + 1;
        int cur = left + 1;
        while (cur < greater) {
            if (nums[cur] == pivot) {
                cur++;
            } else if (nums[cur] > pivot) {
                greater--;
                swap(nums, cur, greater);
            } else {    // nums[cur] < pivot
                smaller++;
                swap(nums, cur, smaller);
                cur++;
            }
        }
        swap(nums, left, smaller);

        sortArray(nums, left, smaller);
        sortArray(nums, cur, right);
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new Solution3_3Ways().sortArray(new int[]{1, 5, 2, 67, 7, 8, 9});

        int n = 1000000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = 2;
        }
//        int[] sortedArray = new Solution2().sortArray(data);
        int[] sortedArray = new Solution3_3Ways().sortArray(ints);
//        double random = Math.random();

//        System.out.println(random);
        System.out.println(Arrays.toString(sortedArray));
    }
}
