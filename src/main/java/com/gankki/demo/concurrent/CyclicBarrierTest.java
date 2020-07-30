package com.gankki.demo.concurrent;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 线程同步工具类
 * CyclicBarrier 线程同步
 * @author liuhao
 * @date 2020/7/30
 */
public class CyclicBarrierTest {
    // 订单队列
    private static Vector<Object> pos;
    // 派送单队列
    private static Vector<Object> dos;
    private static CyclicBarrier barrier;

    /**
     * CyclicBarrier 是一组线程之间互相等待
     * Cyclic /ˈsaɪklɪk/：循环的，周期的
     * @param args
     */
    public static void main(String[] args) {
        // 执行回调的线程池
        Executor executor = Executors.newFixedThreadPool(1);

        barrier = new CyclicBarrier(2, () -> executor.execute(() -> check()));

    }

    static void check () {
        Object p = pos.remove(0);
        Object d = dos.remove(0);
        // 执行对账操作
        System.out.println("diff = check(p, d);");
        // 差异写入差异库
        System.out.println("save(diff);");
    }

    static void checkAll () {
        // 循环查询订单库
        Thread t1 = new Thread(() -> {
            // 存在未对账订单
            boolean notCheckRecord = false;
            while (notCheckRecord) {
                // 查询订单库
                System.out.println("pos.add(getPOrders());");
                try {
                    // 等待
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        // 循环查询运单库
        Thread t2 = new Thread(() -> {
            // 存在未对账订单
            boolean notCheckRecord = false;
            while (notCheckRecord) {
                // 查询运单库
                System.out.println("dos.add(getDOrders());");
                try {
                    // 等待
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }


}
