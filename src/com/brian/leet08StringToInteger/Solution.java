package com.brian.leet08StringToInteger;

/**
 * @author : brian
 * @since 0.1
 */
public class Solution {
    public int myAtoi(String s) {

        //    作者：jyd
        //    链接：https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solution/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/
        //    来源：力扣（LeetCode）
        //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        char[] c = s.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;

    }
}
