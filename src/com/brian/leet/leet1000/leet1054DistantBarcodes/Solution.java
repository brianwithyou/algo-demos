package com.brian.leet.leet1000.leet1054DistantBarcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Barcode: 条形码
 * 
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * 
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * 
 * 示例 1：
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 *
 * 示例 2：
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 * 
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 思路： 直接取count最大的，然后一个一个排列
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/distant-barcodes/solution/ju-chi-xiang-deng-de-tiao-xing-ma-by-lee-31qt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int b : barcodes) {
            if (!count.containsKey(b)) {
                count.put(b, 0);
            }
            count.put(b, count.get(b) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        int n = barcodes.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int[] p = pq.poll();
            int cx = p[0], x = p[1];
            if (i == 0 || res[i - 1] != x) {
                res[i] = x;
                if (cx > 1) {
                    pq.offer(new int[]{cx - 1, x});
                }
            } else {
                int[] p2 = pq.poll();
                int cy = p2[0], y = p2[1];
                res[i] = y;
                if (cy > 1) {
                    pq.offer(new int[]{cy - 1, y});
                }
                pq.offer(new int[]{cx, x});
            }
        }
        return res;
    }


}
