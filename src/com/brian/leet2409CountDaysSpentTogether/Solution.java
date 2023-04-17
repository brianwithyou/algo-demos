package com.brian.leet2409CountDaysSpentTogether;

/**
 * 2409. 统计共同度过的日子数
 * Alice 和 Bob 计划分别去罗马开会。
 * 给你四个字符串arriveAlice，leaveAlice，arriveBob和leaveBob。Alice 会在日期arriveAlice到leaveAlice之间在城市里（日期为闭区间），而 Bob 在日期arriveBob到leaveBob之间在城市里（日期为闭区间）。每个字符串都包含 5 个字符，格式为"MM-DD"，对应着一个日期的月和日。
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * 你可以假设所有日期都在 同一个自然年，而且 不是闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]。
 *
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 *
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 * 
 * 所有日期的格式均为"MM-DD"。
 * Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
 * 题目测试用例所给出的日期均为 非闰年 的有效日期。
 *
 * 链接：https://leetcode.cn/problems/count-days-spent-together
 * @author : brian
 * @since 0.1
 */
public class Solution {

    private int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] prefixSum;

    /**
     * 前缀和
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        prefixSum = new int[13];
        for (int i = 0; i < 12; i++) {
            prefixSum[i + 1] = prefixSum[i] + daysPerMonth[i];
        }

        int aliceArrive = countDaysFromYearBegin(arriveAlice);
        int aliceLeave = countDaysFromYearBegin(leaveAlice);
        int bobArrive = countDaysFromYearBegin(arriveBob);
        int bobLeave = countDaysFromYearBegin(leaveBob);

        return Math.max(0, Math.min(aliceLeave, bobLeave) - Math.max(aliceArrive, bobArrive) + 1);
    }

    public int countDaysFromYearBegin(String date) {
        // date mm-DD
        String[] dateSplit = date.split("-");
        return prefixSum[Integer.parseInt(dateSplit[0]) - 1] + Integer.parseInt(dateSplit[1]);
    }

}
