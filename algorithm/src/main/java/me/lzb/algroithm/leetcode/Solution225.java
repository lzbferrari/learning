package me.lzb.algroithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author LZB
 */
class Solution225 {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private boolean isOne;


    /** Initialize your data structure here. */
    public Solution225() {
        queue1 = new LinkedList();
        queue2 = new LinkedList();
        isOne = true;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (isOne) {
            queue1.add(x);
        } else {
            queue2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int r;
        if (isOne) {

            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            r = queue1.poll();
            isOne = false;
        } else {

            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }
            r = queue2.poll();
            isOne = true;
        }

        return r;
    }

    /** Get the top element. */
    public int top() {
        int r = pop();
        push(r);
        return r;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
