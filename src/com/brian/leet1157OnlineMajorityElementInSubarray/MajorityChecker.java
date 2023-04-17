package com.brian.leet1157OnlineMajorityElementInSubarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1157. 子数组中占绝大多数的元素
 * 设计一个数据结构，有效地找到给定子数组的 多数元素 。
 * 子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。
 * 实现 MajorityChecker 类:
 * MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。
 * int query(int left, int right, int threshold) 返回子数组中的元素  arr[left...right] 至少出现 threshold 次数，如果不存在这样的元素则返回 -1。
 *
 * 输入:
 * ["MajorityChecker", "query", "query", "query"]
 * [[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
 * 输出：
 * [null, 1, -1, 2]
 * 解释：
 * MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
 * majorityChecker.query(0,5,4); // 返回 1
 * majorityChecker.query(0,3,3); // 返回 -1
 * majorityChecker.query(2,3,2); // 返回 2
 *
 * 1 <= arr.length <= 2 * 104
 * 1 <= arr[i] <= 2 * 104
 * 0 <= left <= right < arr.length
 * threshold <= right - left + 1
 * 2 * threshold > right - left + 1
 * 调用 query 的次数最多为 10^4
 *
 * @author : brian
 * @since 0.1
 */
public class MajorityChecker {
    private int n;
    private int[] arr;
    private Map<Integer, List<Integer>> loc;
    private Node[] tree;

    /**
     * 前置知识：
     * 摩尔投票算法 和 线段树
     *
     * 「169. 多数元素」中的「Boyer-Moore 投票算法」；
     *
     * 线段树初步
     *  303. 区域和检索 - 数组不可变
     *  307. 区域和检索 - 数组可修改
     */
    public MajorityChecker(int[] arr) {
        this.n = arr.length;
        this.arr = arr;
        this.loc = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arr.length; ++i) {
            loc.putIfAbsent(arr[i], new ArrayList<Integer>());
            loc.get(arr[i]).add(i);
        }

        this.tree = new Node[n * 4];
        for (int i = 0; i < n * 4; i++) {
            tree[i] = new Node();
        }
        segBuild(0, 0, n - 1);
    }

    public int query(int left, int right, int threshold) {
        Node ans = new Node();
        segQuery(0, 0, n - 1, left, right, ans);
        List<Integer> pos = loc.getOrDefault(ans.x, new ArrayList<Integer>());
        int occ = searchEnd(pos, right) - searchStart(pos, left);
        return occ >= threshold ? ans.x : -1;
    }

    private void segBuild(int id, int l, int r) {
        if (l == r) {
            tree[id] = new Node(arr[l], 1);
            return;
        }

        int mid = (l + r) / 2;
        segBuild(id * 2 + 1, l, mid);
        segBuild(id * 2 + 2, mid + 1, r);
        tree[id].add(tree[id * 2 + 1]);
        tree[id].add(tree[id * 2 + 2]);
    }

    private void segQuery(int id, int l, int r, int ql, int qr, Node ans) {
        if (l > qr || r < ql) {
            return;
        }
        if (ql <= l && r <= qr) {
            ans.add(tree[id]);
            return;
        }

        int mid = (l + r) / 2;
        segQuery(id * 2 + 1, l, mid, ql, qr, ans);
        segQuery(id * 2 + 2, mid + 1, r, ql, qr, ans);
    }

    private int searchStart(List<Integer> pos, int target) {
        int low = 0, high = pos.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int searchEnd(List<Integer> pos, int target) {
        int low = 0, high = pos.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

class Node {
    int x;
    int cnt;
    public Node() {
        this(0, 0);
    }
    public Node(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
    public void add(Node that) {
        if (x == that.x) {
            cnt += that.cnt;
        } else if (cnt >= that.cnt) {
            cnt -= that.cnt;
        } else {
            x = that.x;
            cnt = that.cnt - cnt;
        }
    }
}
