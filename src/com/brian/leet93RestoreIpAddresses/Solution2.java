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
public class Solution2 {

    List<String> result = new ArrayList<>();

    /**
     * 自顶向下的递归
     */
    public List<String> restoreIpAddresses(String s) {
        restoreIpAddresses(s, 4, 0, "");
        return result;
    }

    /**
     *
     * @param s string
     * @param ipSegCount 要寻找的ip段 数量
     * @param index 查找到的索引位置，从0开始
     */
    public void restoreIpAddresses(String s, int ipSegCount, int index, String ip) {
        if (ipSegCount == 1) {
            if (isIpSegment(s.substring(index))) {
                result.add(ip + s.substring(index));
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            String segment = s.substring(index, index + i);
            if (isIpSegment(segment)) {
                restoreIpAddresses(s, ipSegCount - 1, index + i, ip + segment + ".");
            }
        }
    }
    public boolean isIpSegment(String s) {
        if (s.length() == 0 || s.length() >= 4)
            return false;
        if (s.startsWith("0") && !"0".equals(s)) {
            return false;
        }
        int sInt = Integer.parseInt(s);
        if (sInt >= 0 && sInt <= 255) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String test = "25525511135";
        List<String> strings = new Solution2().restoreIpAddresses(test);
        System.out.println(strings);

    }
}
