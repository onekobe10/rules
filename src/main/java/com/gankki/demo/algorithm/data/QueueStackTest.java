package com.gankki.demo.algorithm.data;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 队列
 * @author liuhao
 * @date 2020/9/12
 */
public class QueueStackTest {

    public static void main(String[] args) {
        /**
         *      public boolean add(E e) {
         *         if (offer(e))
         *             return true;
         *         else
         *             throw new IllegalStateException("Queue full");
         *     }
         *   1. 如果容量满了 add 会抛出 IllegalStateException 异常，offer 会返回 false
         *   2. poll 获取队列头部元素，如果有，则返回并删除，如果没有，则返回为 null
         *   3. peek 获取队列头部元素，如果没有，则返回为 null
         */
        Queue<Integer> queue1 = new LinkedBlockingQueue<>(1);
        System.out.println(queue1.offer(1));
        System.out.println(queue1.offer(1));

        Queue<Integer> queue2 = new LinkedBlockingQueue<>(1);
        queue2.add(1);
        //queue2.add(1);

        Stack stack = new Stack();

    }

}
