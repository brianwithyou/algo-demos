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
public class Solution2 {

    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 优化1：随机化pivot
     * 优化2：左右双指针向中间移动，两边都可以包含等于pivot的，防止partition偏向一侧
     */
    public void sortArray(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int p = partition(nums, left, right);
        sortArray(nums, left, p - 1);
        sortArray(nums, p + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        if (left >= right) {
            return left;
        }
        // 【优化1】随机化pivot，在 近乎有序的数组中 加快排序速度
        int random = (int) (left + (right - left) * Math.random());
        swap(nums, left, random);

        int pivot = nums[left];

        // [left + 1, smaller] pivot  [greater, right]
        int smaller = left + 1;
        int greater = right;

        while (true) {

            while (greater >= left + 1 && nums[greater] >= pivot) {
                greater--;
            }
            while (smaller <= right && nums[smaller] <= pivot) {
                smaller++;
            }

            if (smaller > greater) {
                break;
            }
            swap(nums, smaller, greater);
            smaller++;
            greater--;
        }

        swap(nums, left, greater);
        return greater;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new Solution2().sortArray(new int[]{1, 5, 2, 67, 7, 8, 9});

        int n = 1000000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = 2;
        }
//        int[] sortedArray = new Solution2().sortArray(data);
        int[] sortedArray = new Solution2().sortArray(ints);
//        double random = Math.random();

//        System.out.println(random);
        System.out.println(Arrays.toString(sortedArray));
    }
}
