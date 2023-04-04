package com.brian.leet877StoneGame;

/**
 * 877. 石子游戏
 * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i]。
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回true，当 Bob 赢得比赛时返回false。
 *
 * 链接：https://leetcode.cn/problems/stone-game
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 因为是 偶数个石堆，奇数个石头，将石堆 分成 奇数堆 和偶数堆  1 3 5 7   2 4 6 8
     * 这两堆肯定不相等，有个多个(因为是奇数个石头)
     *
     * 先手可以决定自己拿 奇数堆1  还是 偶数堆last,
     * 所以开始之前 如果看到了 奇数堆多 还是 偶数堆 多 就拿哪一堆
     *
     *
     * 可以用递归、记忆化搜索、动态规划，参考第 486. 预测赢家
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
