package com.brian.leet91DecodeWays;

/**
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : brian
 * @since 0.1
 */
public class Solution0_Recusrion_timeout {
    // 两种情况 1. "0"开头  2. 非0开头，且前两位 小于等于26
    public int numDecodings(String s) {
        return numDecodings(s, 0);
    }
    public int numDecodings(String s, int index) {

        if (index == s.length()) {
            return 0;
        }
        if (s.charAt(index) == '0')
            return 0;
        if (index == s.length() - 1) {
            return 1;
        }
        if (index == s.length() - 2 && Integer.parseInt(s.substring(index)) <= 26) {
            // 截取两位时，末位是0，return 1，末位不是0 return 2
            if (s.endsWith("0")) {
                return 1;
            }
            return 2;
        }

        int res = 0;
        if (!s.startsWith("0"))
            res += numDecodings(s, index + 1);

        if (!s.startsWith("0") && Integer.parseInt(s.substring(index, index + 2)) <= 26)
            res += numDecodings(s, index + 2);

        return res;
    }

    public static void main(String[] args) {
//        int i = new Solution().numDecodings("10");
        int i = new Solution0_Recusrion_timeout().numDecodings("12");
//        int i = new Solution().numDecodings("226"); // 3
        System.out.println(i);
    }
}
