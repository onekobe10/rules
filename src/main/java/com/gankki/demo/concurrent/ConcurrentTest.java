package com.gankki.demo.concurrent;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author liuhao
 * @date 2020/8/17
 */
public class ConcurrentTest {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        /**
         * 默认最大是 Integer.MAX_VALUE，其中主要用到 put 和 take 方法，put 方法在队列满的时候会阻塞直到有队列成员被消费，
         * take方法在队列空的时候会阻塞，直到有队列成员被放进来。
         */
        BlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        linkedBlockingQueue.put(1);
        linkedBlockingQueue.put(2);
        linkedBlockingQueue.put(3);
        // linkedBlockingQueue.put(4);
        // linkedBlockingQueue.put(5);

        // 无界阻塞。无界：添加不会阻塞，为空时，获取阻塞。
        BlockingQueue<Integer> priorityQueue = new PriorityBlockingQueue<>(3);
        priorityQueue.take();
        priorityQueue.take();
    }


}
