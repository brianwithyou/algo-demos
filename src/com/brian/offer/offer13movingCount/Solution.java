package com.brian.offer.offer13movingCount;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * @author : brian
 * @since 0.1
 */
public class Solution {

    int res = 0;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        movingCount(m, n, 0, 0, k);
        return res;
    }
    public void movingCount(int m, int n, int startX, int startY, int k) {
        if (!inArea(m, n, startX, startY))
            return;
        int num1 = startX / 10;
        int num2 = startX % 10;
        int num3 = startY / 10;
        int num4 = startY % 10;
        if (!visited[startX][startY] && num1 + num2 + num3 + num4 <= k) {
            visited[startX][startY] = true;
//            System.out.printf("(%s, %s) <= %s\n", startX, startY, k);
            res++;
            // 只向右 向下走即可
            movingCount(m, n, startX + 1, startY, k);
            movingCount(m, n, startX, startY + 1, k);
        }
    }
    public boolean inArea(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
//        int i = new Solution().movingCount(2, 3, 1);    // 3
//        int i = new Solution().movingCount(3, 1, 0); // 1
        int i = new Solution().movingCount(3, 2, 17); // 6
        System.out.println(i);
    }
}
