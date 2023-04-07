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
public class MyStack1 {
    Queue<Integer> queue1;
    public MyStack1() {
        // 可以用2个队列实现栈，也可以用1个队列实现栈，进阶：你能否仅用一个队列来实现栈（Solution1）。
        queue1 = new LinkedList<>();
    }

    // 只要保证push的元素一直在队列头即可
    public void push(int x) {
        int size = queue1.size();
        queue1.offer(x);
        // 加入尾结点以后，前面的所有节点重新出来 继续加入尾结点，保证新加入的在第一个节点
        for (int i = 0; i < size; i++) {
            queue1.add(queue1.poll());
        }
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack1 myStack = new MyStack1();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}
