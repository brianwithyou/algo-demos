package com.brian.leet970PowerfulIntegers;

import java.util.ArrayList;
import java.util.List;

/**
 * 970. 强整数
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 * <p>
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        List<Integer> res = new ArrayList<>();

        // 无论所少次幂，值只有2 这一个
        if (x == 1 && y == 1) {
            // 最小是2， 因为 x^0 + y^0 = 2
            if (bound > 1) {
                res.add(2);
            }
            return res;
        }

        if (x == 1) {
            for (int i= 0; Math.pow(y, i) < bound - 1; i++) {
                res.add((int) (1 + Math.pow(y, i)));
            }
            return res;
        }

        if (y == 1) {
            for (int i= 0; Math.pow(x, i) < bound - 1; i++) {
                res.add((int) (1 + Math.pow(x, i)));
            }
            return res;
        }
        for (int i = 0; Math.pow(x, i) < bound; i++) {
            for (int j = 0; Math.pow(y, j) <= bound; j++) {
                double sum = Math.pow(x, i) + Math.pow(y, j);
                if (sum <= bound && !res.contains((int)sum)) {
                    res.add((int) sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        List<Integer> list = new Solution().powerfulIntegers(2, 3, 10); // 2,3,4,5,7,9,10
        List<Integer> list = new Solution().powerfulIntegers(3, 5, 15); // 2,4,6,8,10,14
//        List<Integer> list = new Solution().powerfulIntegers(2, 1, 10);
//        List<Integer> list = new Solution().powerfulIntegers(1, 1, 1);
        System.out.println(list);
    }
}
