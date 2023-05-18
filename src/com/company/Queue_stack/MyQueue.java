package com.company.Queue_stack;


import java.util.Stack;

/**
 * 使用栈实现队列的先进先出操作
 */
public class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    //初始化数据结构
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    //将元素x添加到序列中
    public void push(int x) {
        inStack.push(x);
    }

    //弹出元素并返回
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                // 弹出inStack中的元素存入到outStack中
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    //获取序列中的元素，而不对里面的元素进行操作
    public int peek() {

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    //返回序列是否为空
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
