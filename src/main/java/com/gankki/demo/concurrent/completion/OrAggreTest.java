package com.gankki.demo.concurrent.completion;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * OR 汇聚
 *
 * @author liuhao
 * @date 2020/8/18
 */
public class OrAggreTest {

    /**
     * 1. 描述 OR 汇聚关系的相关方法：
     * CompletionStage applyToEither(other, fn);
     * CompletionStage applyToEitherAsync(other, fn);
     * CompletionStage acceptEither(other, consumer);
     * CompletionStage acceptEitherAsync(other, consumer);
     * CompletionStage runAfterEither(other, action);
     * CompletionStage runAfterEitherAsync(other, action);
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            long t = new Random().nextInt(3000);
            try {
                Thread.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "..1.." + t);
            return String.valueOf(t);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            long t = new Random().nextInt(3000);
            try {
                Thread.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "..2.." + t);
            return String.valueOf(t);
        });

        /**
         * f1, f2 中执行完成快的，执行 either 的回调函数，回调函数的结果是一个 ComletableFuture 实例。
         */
        CompletableFuture<String> f3 = f1.applyToEither(f2, s -> {
            System.out.println("final...." + s);
            return s;
        });

        // Thread.sleep(5000);
        System.out.println(f3.join());
    }

}
