package com.company.Queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    //定义两个队列，q1队列存储和栈保持一致
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    //在MyStack类中初始化一个构造器
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * 设计栈的 push 函数，先将值存入辅助队列q2中，且判断q1中是否有值，将q1值弹出也存储到q2中，最后进行交换，将q1的值存储到q2中
     *
     * @param x
     */
    public void push(int x) {
        //先将值存储到q2中
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp;

    }

    /**
     * 因queue1 和 栈保持一致，故其pop函数则对应于poll 函数，直接弹出即可
     *
     * @return
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * 直接返回queue1的top元素
     *
     * @return
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * 判断栈中是否为空
     *
     * @return
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

}
