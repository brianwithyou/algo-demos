package com.brian.leet120Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author : brian
 * @since 0.1
 */
public class Solution2_MemorySearch {

    /**
     * 递归
     */
    int[][] memory;
    public int minimumTotal(List<List<Integer>> triangle) {
        memory = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            Arrays.fill(memory[i], Integer.MAX_VALUE);
        }
        return minimumTotal(triangle, 0, 0);

    }
    public int minimumTotal(List<List<Integer>> triangle, int startX, int startY) {
        if (startX == triangle.size())
            return 0;

        if (memory[startX][startY] != Integer.MAX_VALUE) {
            return memory[startX][startY];
        }
        int sum = triangle.get(startX).get(startY) + minimumTotal(triangle, startX + 1, startY);
        if (startX + 1 < triangle.size() && startY + 1 < triangle.get(startX + 1).size()) {
            sum = Math.min(sum, triangle.get(startX).get(startY) + minimumTotal(triangle, startX + 1, startY + 1));
        }
        memory[startX][startY] = sum;
        return sum;
    }
    public static void main(String[] args) {
//         new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}} // 11
        List<List<Integer>> data = new ArrayList<>() {{
            add(new ArrayList<>(){{add(2);}});
            add(new ArrayList<>(){{add(3);add(4);}});
            add(new ArrayList<>(){{add(6);add(5);add(7);}});
            add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
        }};
        int i = new Solution2_MemorySearch().minimumTotal(data);
        System.out.println(i);

//        List<List<Integer>> data = new ArrayList<>() {{
//            add(new ArrayList<>(){{add(-1);}});
//            add(new ArrayList<>(){{add(-2);add(-3);}});
//        }};
//        int i = new Solution2().minimumTotal(data);
//        System.out.println(i);
    }

}
