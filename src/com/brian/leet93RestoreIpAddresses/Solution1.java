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
public class Solution1 {

    /**
     * 自底向上递归
     */
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(s, 4, 0);
    }
    public List<String> restoreIpAddresses(String s, int segCount, int index) {
        List<String> res = new ArrayList<>();
        if (index == s.length())
            return res;
        if (segCount == 0)
            return res;
        if (segCount == 1) {
            if (isIpSegment(s.substring(index))) {
                res.add(s.substring(index));
            }
            return res;
        }

        for (int i = 1; i <= 3; i++) {
            if (index + i < s.length() && isIpSegment(s.substring(index, index + i))) {
                List<String> innerRes = restoreIpAddresses(s, segCount - 1, index + i);
                for (int j = 0; j < innerRes.size(); j++) {
                    res.add(s.substring(index, index + i) + "." + innerRes.get(j));
                }
            }
        }
        return res;
    }
    public boolean isIpSegment(String s) {
        if (s == null)
            return false;
        if (s.length() == 0 || s.length() >= 4) {
            return false;
        }
        if (s.startsWith("0") && !"0".equals(s)) {
            return false;
        }
        int sInt = Integer.parseInt(s);
        if (sInt >= 0 && sInt <= 255)
            return true;
        return false;
    }


    public static void main(String[] args) {
//        String test = "25525511135";
        String test = "0000";

        List<String> strings = new Solution1().restoreIpAddresses(test);
        System.out.println(strings);

//        StringBuilder tempStrBuilder = new StringBuilder("255.255.111.35");
//        tempStrBuilder.delete(tempStrBuilder.lastIndexOf("."), tempStrBuilder.length());
//        System.out.println(tempStrBuilder);
    }
}
