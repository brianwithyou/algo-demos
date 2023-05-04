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
public class Solution4_MergeSort {

    private int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        int i = left;
        int j = mid + 1;
        // 执行已排序树组的下一个元素
        int cur = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[cur] = nums[i];
                cur++;
                i++;
            } else {    // nums[i] >= nums[j]
                temp[cur] = nums[j];
                cur++;
                j++;
            }
        }
        while (i <= mid) {
            temp[cur] = nums[i];
            cur++;
            i++;
        }
        while (j <= right) {
            temp[cur] = nums[j];
            cur++;
            j++;
        }
        // 将已排序树组temp覆盖进nums数组
        for (int k = 0; k < cur; k++) {
            nums[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution4_MergeSort().sortArray(new int[]{1, 5, 2, 67, 7, 8, 9});

        int n = 1000000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = 2;
        }
//        int[] sortedArray = new Solution2().sortArray(data);
        int[] sortedArray = new Solution4_MergeSort().sortArray(ints);
//        double random = Math.random();

//        System.out.println(random);
        System.out.println(Arrays.toString(sortedArray));
    }
}
