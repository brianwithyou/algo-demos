package com.brian.leet.leet0000.leet49GroupAnagrams;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * @author Brian
 * @date 2023/6/7
 **/
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // key只能是string，不能是char array，因为char array的hash值不同
            String key = new String(chars);
            List<String> res = resMap.getOrDefault(key, new ArrayList<>());
            res.add(str);
            resMap.put(key, res);
        }
        return new ArrayList<>(resMap.values());
    }
}
