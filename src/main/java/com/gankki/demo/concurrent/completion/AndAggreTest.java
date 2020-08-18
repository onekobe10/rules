package com.gankki.demo.concurrent.completion;

import java.util.concurrent.CompletableFuture;

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
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("并行执行1....." + Thread.currentThread().getName());
            return  "liuhao";
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
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

    }
    
}
