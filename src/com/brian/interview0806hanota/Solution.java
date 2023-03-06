package com.brian.interview0806hanota;

import java.util.ArrayList;
import java.util.List;

/**
 * 汉诺塔问题 Towers of Hanoi
 *  Input: A = [2, 1, 0], B = [], C = []
 *  Output: C = [2, 1, 0]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        move(A.size(), A, B, C);

    }
    void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(0, A.remove(0));
            return;
        }
        move(n - 1, A, C, B);
        C.add(0, A.remove(0));
        move(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>() {{
            add(2);
            add(1);
            add(0);
        }};
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        new Solution().hanota(list1, list2, list3);

        System.out.println();
    }
}
