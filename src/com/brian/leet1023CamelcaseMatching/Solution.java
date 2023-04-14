package com.brian.leet1023CamelcaseMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 如果我们可以将小写字母插入模式串pattern得到待查询项query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表queries，和模式串pattern，返回由布尔值组成的答案列表answer。只有在待查项queries[i] 与模式串pattern 匹配时，answer[i]才为 true，否则为 false。
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输出：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * 链接：https://leetcode.cn/problems/camelcase-matching
 *
 * @author : brian
 * @since 0.1
 */
public class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>(queries.length);

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            result.add(validPrefix(query, pattern));
        }
        return result;
    }

    public boolean validPrefix(String query, String pattern) {

        int queryIdx = 0;
        int patternIdx = 0;
        while (queryIdx < query.length() || patternIdx < pattern.length()) {
            if (queryIdx < query.length() && patternIdx >= pattern.length()) {
                if (Character.isUpperCase(query.charAt(queryIdx))) {
                    return false;
                } else {
                    queryIdx++;
                }
            } else if (queryIdx >= query.length() && patternIdx < pattern.length()) {
                return false;
            } else { // if (queryIdx < query.length() && patternIdx < pattern.length())

                if (Character.isUpperCase(query.charAt(queryIdx)) && Character.isUpperCase(pattern.charAt(patternIdx))) {
                    if (query.charAt(queryIdx) != pattern.charAt(patternIdx)) {
                        return false;
                    }
                    patternIdx++;
                    queryIdx++;
                } else if (Character.isLowerCase(query.charAt(queryIdx)) && Character.isUpperCase(pattern.charAt(patternIdx))){
                    queryIdx++;
                } else if (Character.isUpperCase(query.charAt(queryIdx)) && Character.isLowerCase(pattern.charAt(patternIdx))) {
                    return false;
                } else if (Character.isLowerCase(query.charAt(queryIdx)) && Character.isLowerCase(pattern.charAt(patternIdx))) {
                    if (query.charAt(queryIdx) == pattern.charAt(patternIdx)) {
                        queryIdx++;
                        patternIdx++;
                    } else {
                        queryIdx++;
                    }
                }

                // prefix都满足的
//                if (Character.isUpperCase(pattern.charAt(patternIdx)) && !Character.isUpperCase(query.charAt(queryIdx))) {
//                    queryIdx++;
//                } else {
//                    if (query.charAt(queryIdx) != pattern.charAt(patternIdx)) {
//                        return false;
//                    }
//                    queryIdx++;
//                    patternIdx++;

//                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // [true,false,true,true,false]
//        String[] data = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
//        String pattern = "FB";

        // * 输出：[true,false,true,false,false]
//        String[] data = new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
//        String pattern = "FoBa";

        // [false,false,true]
        String[] data = new String[]{"CompetitiveProgramming","CounterPick","ControlPanel"};
        String pattern = "CooP";
        Solution solution = new Solution();
        List<Boolean> booleans = solution.camelMatch(data, pattern);
        System.out.println(Arrays.toString(new List[]{booleans}));
    }
}
