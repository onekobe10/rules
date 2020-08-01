package com.gankki.demo.concurrent.cyclicbarrier;

import java.util.Vector;
import java.util.concurrent.*;

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
     * 循环栅栏 cyclic /ˈsaɪklɪk/：循环的，周期的
     * 1. CyclicBarrier 是一组线程之间互相等待
     * 2. CyclicBarrier 的计数器是可以循环利用的，而且具备自动重置的功能，一旦计数器减到 0 会自动重置到你设置的初始值。
     * 3. 实现原理: 根据 ReentrantLock 实现，每次调用CyclicBarrier 的 await() 方法的时候都会加锁，
     * 然后将倒计时统计数减 1，如果不是 0，就调用 Lock 的 await 阻塞挂起，倒计时数量为 0，
     * 最后一个到达的线程唤醒其他线程。释放资源，然后执行回调函数，执行完回调函数重置倒计时统计数，可以再次开始循环
     * @param args
     */
    public static void main(String[] args) {
        // 执行回调的线程池
        Executor executor = Executors.newFixedThreadPool(1);

        // 所有线程到达栅栏后，在所有线程执行下一步动作前，运行参数中的动作，这个动作由最后一个到达栅栏的线程执行回调函数
        // 这个动作是一个同步操作，只有执行完回调函数之后才能开启下轮的循环，达不到性能优化的目的
        // 在回调函数中使用线程池中的线程执行，此时就可以开始下一轮的循环，而将线程池设置为 1 可以避免多线程时从 pos doc 中取的结果不一致。
        // 在回调函数中到底是使用最后一个到达的线程还是线程池中的资源，要看循环逻辑和回调逻辑是否有依赖关系。
        // CountDownLatch 不支持循环利用，CyclicBarrier 支持循环利用。
        barrier = new CyclicBarrier(2, () -> executor.execute(() -> check()));

        checkAll ();
    }

    static void check () {
        Object p = pos.remove(0);
        Object d = dos.remove(0);
        // 执行对账操作
        System.out.println("diff = check(p, d);");
        // 差异写入差异库
        System.out.println("save(diff);");
    }

    /**
     * 线程 T1 负责查询订单，当查出一条时，调用 barrier.await() 来将计数器减 1，同时等待计数器变成 0；
     * 线程 T2 负责查询派送单，当查出一条时，也调用 barrier.await() 来将计数器减 1，同时等待计数器变成 0；
     * 当 T1 和 T2 都调用 barrier.await() 的时候，计数器会减到 0，此时 T1 和 T2 就可以执行下一条语句了，
     * 同时会调用 barrier 的回调函数来执行对账操作。
     */
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
                    barrier.await(3000, TimeUnit.MILLISECONDS);
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
