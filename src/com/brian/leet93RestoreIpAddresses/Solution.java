package com.brian.leet93RestoreIpAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 还原IP地址
 * （每个整数位于 0 到 255 之间组成，且不能含有前导 0）
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        restore(s, 0, new ArrayList<>(), 1);

        return result;
    }

    /**
     *
     * @param n 一共4段，正在寻找第n段
     */
    private void restore(String s, int index, List<String> tempStr, int n) {
        if (n > 5) {
            return;
        }
        if (index == s.length() && n == 5) {
            result.add(String.join(".", tempStr));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (index + i >= s.length()) {
                break;
            }
            if (isIpSeg(s.substring(index, index + i + 1))) {

                tempStr.add(s.substring(index, index + i + 1));
                restore(s, index + i + 1, tempStr, n + 1);

                tempStr.remove(tempStr.size() - 1);
            }
        }
    }
    public boolean isIpSeg(String s) {
        if (s.length() > 1)
            return s.length() < 4 && !s.startsWith("0") && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        else if (s.length() == 1)
            return Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 9;

        return false;
    }

    public static void main(String[] args) {
        String test = "25525511135";
        List<String> strings = new Solution().restoreIpAddresses(test);
        System.out.println();

    }
}
