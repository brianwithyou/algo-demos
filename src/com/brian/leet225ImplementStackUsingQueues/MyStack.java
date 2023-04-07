package com.brian.leet225ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 *
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 *
 * 进阶：你能否仅用一个队列来实现栈（Solution1
 *
 * 链接：https://leetcode.cn/problems/implement-stack-using-queues
 * @author : brian
 * @since 0.1
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        // 可以用2个队列实现栈，也可以用1个队列实现栈，进阶：你能否仅用一个队列来实现栈（Solution1）。
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 只要保证push的元素一直在队列头即可
    public void push(int x) {

        queue1.add(x);
        // 此时不能用queue2.size()结尾，因为size是变化的
//        for (int i = 0; i < queue2.size(); i++) {
        for (int i = 0; !queue2.isEmpty(); i++) {
            queue1.add(queue2.poll());
        }

        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
