package com.brian.offer64;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 输入: n = 3
 * 输出: 6
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 1 <= n <= 10000
 *
 * @author : brian
 * @since 0.1
 */
public class Solution1 {
    /**
     * 使用 三目运算符时
     */
    public int sumNums(int n) {
        // && 符号  前面为true 则 后面就不执行了
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
