package com.gankki.demo.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 线程同步工具类
 * CountDownLatch 线程等待
 * @author liuhao
 * @date 2020/7/30
 */
public class CountDownLatchTest {
    public static Executor executor = Executors.newFixedThreadPool(2);

    /**
     * CountDownLatch 实现线程等待：主线程需要等待多个子线程执行完毕之后再执行场景。
     * CountDownLatch 主要用来解决一个线程等待多个线程的场景
     * latch：/lætʃ/ 门闩
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            try {
                // 计数器初始化为2
                CountDownLatch latch = new CountDownLatch(2);
                // 查询未对账订单
                executor.execute(() -> {
                    System.out.println("opt:查询业务1");

                    latch.countDown();
                });
                // 查询派送单
                executor.execute(() -> {
                    System.out.println("opt:查询业务2");

                    latch.countDown();
                });

                // 等待两个查询操作结束
                latch.await();

                /**
                 * 优化点：并行执行完查询操作之后，执行对账操作时，它们之间还是串行的。
                 * 如果在执行对账的时候可以再次执行查询则 CyclicBarrier 可以满足这种类似生产者-消费者模式的场景
                 * 如果在执行对账的时候对账会改变查询操作中的数据则必须等对账完成在从查询开始
                 */

                // 执行对账操作
                System.out.println("opt:diff = check(pos, dos)");

                // 差异写入差异库
                System.out.println("opt:save(diff)");
            } catch (Exception e) {
                System.out.println("异常打印");
            }
        }
    }

}
