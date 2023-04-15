package com.brian.leet1042FlowerPlantingWithNoAdjacent;

import java.util.ArrayList;
import java.util.List;

/**
 * 有 n 个花园，按从1到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi]描述了花园xi 到花园yi 的双向路径。在每个花园中，你打算种下四种花之一。
 *
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回 任一 可行的方案作为答案answer，其中answer[i]为在第(i+1)个花园中种植的花的种类。花的种类用 1、2、3、4 表示。保证存在答案。
 *
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 *
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 *
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * 
 * 提示：
 *
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 *
 * 链接：https://leetcode.cn/problems/flower-planting-with-no-adjacent
 * 
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 【图论】、【邻接表】、【模拟】、【颜色标记】
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        // 生成邻接表
        List<Integer>[] adt = new List[n];
        for(int i = 0;i < n; i++) {
            adt[i] = new ArrayList<>();
        }
        for(int[] p: paths){
            adt[p[0] - 1].add(p[1] - 1); // 注意这里的下标全部减了 1，这一点实在让人便秘
            adt[p[1] - 1].add(p[0] - 1);
        }

        int[] ret = new int[n]; // 初始颜色都是 0，表示没有颜色
        for(int v = 0; v < n; v++){ // 遍历花园
            //遍历花园的邻接点，记录已经被邻接点占用的颜色
            boolean[] colors = new boolean[5];
            for(int u: adt[v]){
                colors[ret[u]] = true; // 花园 u 的颜色被标记为已占用
            }

            // 从 colors 中未占用的颜色里，挑一种给花园 v 使用
            for(int i = 1; i <= 4; i++){
                if(!colors[i]){
                    ret[v] = i;
                    break;
                }
            }
        }
        return ret;
    }
}
