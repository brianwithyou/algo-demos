package com.brian.leet319BulbSwitcher;

/**
 * 初始时有n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
 *
 * 第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 *
 * 找出并返回 n轮后有多少个亮着的灯泡。
 *
 * k 是「完全平方数」时，它才会有奇数个约数，否则一定有偶数个约数。
 *
 * 链接：https://leetcode.cn/problems/bulb-switcher/solution/deng-pao-kai-guan-by-leetcode-solution-rrgp/
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    // 只有完全平方数那个才会开着，否则

    public int bulbSwitch(int n) {
        // 小于等于n的 完全平方数的个数
        return (int) Math.sqrt(n);
    }
}
