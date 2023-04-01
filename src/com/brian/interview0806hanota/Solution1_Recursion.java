package com.brian.interview0806hanota;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔问题 Towers of Hanoi
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/hanota-lcci
 *
 *  Input: A = [2, 1, 0], B = [], C = []
 *  Output: C = [2, 1, 0]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1_Recursion {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }
    public void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(0, A.remove(0));
            return;
        }

        hanota(n - 1, A, C, B);
        Integer remove = A.remove(0);
        C.add(0, remove);
        hanota(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>() {{
            add(2);
            add(1);
            add(0);
        }};
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        new Solution1_Recursion().hanota(list1, list2, list3);

        System.out.println();
    }
}
