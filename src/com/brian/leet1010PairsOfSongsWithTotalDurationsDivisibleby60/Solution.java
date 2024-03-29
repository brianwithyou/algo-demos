package com.brian.leet1010PairsOfSongsWithTotalDurationsDivisibleby60;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 *
 * 提示：
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int i = 0; i < time.length; i++) {
            count[time[i] % 60]++;
        }
        int res = 0;

        // 余数为0的组合 C(n,2)
        res += (long)count[0] * (count[0] - 1) / 2;
        // 余数为30的组合C(n,2)
        res += (long)count[30] * (count[30] - 1) / 2;
        // 余数为 1-29的
        for (int i = 1; i <= 29; i++) {
            res += (long)count[i] * count[60 - i];
        }
        return res;
    }

    public static void main(String[] args) {
//        int num = new Solution().numPairsDivisibleBy60(new int[]{60, 60, 60});  // 3
        int num = new Solution().numPairsDivisibleBy60(new int[]{30,20,150,100,40});  // 3
        System.out.println(num);
    }
}
