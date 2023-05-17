package com.brian.leet.leet2000.leet2446DetermineIfTwoEventsHaveConflict;

/**
 * 2446. 判断两个事件是否存在冲突
 * 给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
 * <p>
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
 * <p>
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
 * <p>
 * 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * 示例 2：
 * <p>
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * 示例 3：
 * <p>
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出：false
 * 解释：两个事件不存在交集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * evnet1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * 所有事件的时间都按照 HH:MM 格式给出
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public boolean haveConflict(String[] event1, String[] event2) {

        if (event1[0].compareTo(event2[0]) < 0) {
            return event1[1].compareTo(event2[0]) >= 0;
        }
        return event2[1].compareTo(event1[0]) >= 0;

    }

    public static void main(String[] args) {
        // ["16:53","19:00"]
        // ["10:33","18:15"]
        String[] event1 = new String[]{"16:53", "19:00"};
        String[] event2 = new String[]{"10:33", "18:15"};
        boolean b = new Solution().haveConflict(event1, event2);
        System.out.println(b);
    }
}
