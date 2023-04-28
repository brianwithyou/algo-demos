package com.brian.leet233NumberOfDigitOne;

/**
 * 233. 数字 1 的个数
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * <p>
 * 输入：n = 13
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 109
 * <p>
 * 链接：https://leetcode.cn/problems/number-of-digit-one
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/number-of-digit-one/solution/shu-zi-1-de-ge-shu-by-leetcode-solution-zopq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }


}
