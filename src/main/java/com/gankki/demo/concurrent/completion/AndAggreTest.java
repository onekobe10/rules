package com.gankki.demo.concurrent.completion;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * AND 汇聚
 * @author liuhao
 * @date 2020/8/18 
 */
public class AndAggreTest {
    
    /**
     * 1. 描述 AND 汇聚关系的相关方法：
     * CompletionStage<R> thenCombine(other, fn);
     * CompletionStage<R> thenCombineAsync(other, fn);
     * CompletionStage<Void> thenAcceptBoth(other, consumer);
     * CompletionStage<Void> thenAcceptBothAsync(other, consumer);
     * CompletionStage<Void> runAfterBoth(other, action);
     * CompletionStage<Void> runAfterBothAsync(other, action);
     *
     * @author liuhao
     * @date 2020/8/18 
     */
    public static void main(String[] args) {
        System.out.println("主线程....." + Thread.currentThread().getName());
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {// 异步流程
            System.out.println("并行执行1....." + Thread.currentThread().getName());
            return  "liuhao";
        }, testAsyncPool());// 指定线程池，根据不同的业务类型创建不同的线程池，以避免互相干扰。
        // 默认情况下 CompletableFuture 会使用公共的 ForkJoinPool 线程池，这个线程池默认创建的线程数是 CPU 的核数
        // （也可以通过 JVM option:-Djava.util.concurrent.ForkJoinPool.common.parallelism 来设置 ForkJoinPool 线程池的线程数）

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {// 异步流程
            System.out.println("并行执行2....." + Thread.currentThread().getName());
            return 2020;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {// 异步流程
            System.out.println("并行执行2....." + Thread.currentThread().getName());
            return 2020;
        });

        /**
         * thenAcceptBoth/thenAcceptBothAysnc 决定了回调函数是异步还是同步
         * accept 可以将异步线程的参数作为入参，但是没有返回结果
         */
        CompletableFuture finalFuture1 = future1.thenAcceptBothAsync(future2, (integer, s) -> {
            System.out.println("并行执行 1&2 的结果汇总1....." + Thread.currentThread().getName());
            System.out.println(integer + " , " + s);
        });
        System.out.println(finalFuture1.join() + "...1");// null...1

        /**
         * combine 可以将异步线程的参数作为入参，回调函数也需要返回结果
         */
        CompletableFuture finalFuture2 = future1.thenCombineAsync(future2, (integer, s) -> {
            System.out.println("并行执行 1&2 的结果汇总2....." + Thread.currentThread().getName());
            System.out.println(integer + " , " + s);
            return integer + "..." + s;
        });
        System.out.println(finalFuture2.join() + "...2");// liuhao...2020...2

        /**
         * runAfter 的回调函数既没有入参也没有返回结果
         *
         */
        CompletableFuture finalFuture3 = future1.runAfterBothAsync(future2, () -> {
            System.out.println("并行执行 1&2 的结果汇总3....." + Thread.currentThread().getName());
        });
        System.out.println(finalFuture3.join() + "...3");// null...3

        CompletableFuture.allOf(future1, future2, future3).thenRun(() -> {
            System.out.println("两个以上future的 and 操作");
        });

    }

    private static Executor testAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池大小
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        //最大线程数
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
        //队列容量
        executor.setQueueCapacity(60);
        //活跃时间
        executor.setKeepAliveSeconds(60);
        //线程名字前缀
        executor.setThreadNamePrefix("test-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }
    
}
