package com.brian.leet1147LongestChunkedPalindromeDecomposition;

/**
 * 1147. 段式回文
 * 你会得到一个字符串text。你应该把它分成 k个子字符串(subtext1, subtext2，…， subtextk)，要求满足:
 *
 * subtexti是 非空字符串
 * 所有子字符串的连接等于 text ( 即subtext1+ subtext2+ ... + subtextk== text)
 * 对于所有 i的有效值( 即1 <= i<= k ) ，subtexti== subtextk - i + 1 均成立
 * 返回k可能最大值。
 *
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 *
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 *
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 *
 * 链接：https://leetcode.cn/problems/longest-chunked-palindrome-decomposition
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    // Decomposition 分解   Chunked 块化的，一大块的  chunk n.大块；相当大的部分；〈美〉矮胖结实的人；结实的马 网络 分块；块传输编码；块编码
    public int longestDecomposition(String text) {

        int res = 1;
        int n = text.length();
        if (n <= 1) {
            return n;
        }
        int right = n - 1;

        while (!text.startsWith(text.substring(right))) {
            right--;
            if (right < text.length() / 2) {
                return 1;
            }
        }

        return Math.max(res, 2 + longestDecomposition(text.substring(n - right, right)));
    }

    public static void main(String[] args) {
//        int length = new Solution().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi");
//        int length = new Solution().longestDecomposition("merchant");
//        int length = new Solution().longestDecomposition("antaprezatepzapreanta");
        int length = new Solution().longestDecomposition("elvtoelvto");
        System.out.println(length);

    }
}
