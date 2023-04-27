package com.brian.offer.offer59_2MaxQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 * @author : brian
 * @since 0.1
 */
public class MaxQueue {

    private Queue<Integer> queue;
    // 单调递减双端队列
    private Deque<Integer> maxQueue;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.maxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty())
            return -1;
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }

        // 必须是addLast add不行
        maxQueue.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        Integer poll = queue.poll();
        if (poll.equals(maxQueue.peekFirst())) {
            maxQueue.pollFirst();
        }
        return poll;
    }
}
