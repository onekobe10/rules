package com.gankki.demo.concurrent.completion;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * 串行关系
 * 先执行 A，在执行 B
 *
 * @author liuhao
 * @date 2020/8/18
 */
public class SerialTest {

    /**
     * 1. 串行执行的相关方法：(串行执行没必要使用 CompletableFuture)
     * CompletionStage<R> thenApply(fn);
     * CompletionStage<R> thenApplyAsync(fn);
     * CompletionStage<Void> thenAccept(consumer);
     * CompletionStage<Void> thenAcceptAsync(consumer);
     * CompletionStage<Void> thenRun(action);
     * CompletionStage<Void> thenRunAsync(action);
     * CompletionStage<R> thenCompose(fn);
     * CompletionStage<R> thenComposeAsync(fn);
     *
     * 1. thenApply 系列函数里参数 fn 的类型是接口 Function<T, R>，这个接口里与 CompletionStage 相关的方法是 R apply(T t)，
     * 这个方法既能接收参数也支持返回值，所以 thenApply 系列方法返回的是CompletionStage<R>。
     * <p>
     * 2. thenAccept 系列方法里参数 consumer 的类型是接口Consumer，这个接口里与 CompletionStage 相关的方法是 void accept(T t)，
     * 这个方法虽然支持参数，但却不支持回值，所以 thenAccept 系列方法返回的是CompletionStage<Void>。
     * <p>
     * 3. thenRun 系列方法里 action 的参数是 Runnable，
     * 所以 action 既不能接收参数也不支持返回值，所以 thenRun 系列方法返回的也是CompletionStage<Void>。
     * <p>
     * 4. 这些方法里面 Async 代表的是异步执行 fn、consumer 或者 action。
     * 其中，需要你注意的是 thenCompose 系列方法，这个系列的方法会新创建出一个子流程，最终结果和 thenApply 系列是相同的。
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName() + "............1");
        CompletableFuture<String> f0 =
                CompletableFuture.supplyAsync(// 异步流程，之后的每一步是串行执行的。
                        () -> {
                            System.out.println(Thread.currentThread().getName() + "............2");
                            return "2";
                        }, Executors.newCachedThreadPool())// 指定线程池
                        .thenApply(s -> {
                            System.out.println("有入参有返回值......." + s);
                            System.out.println(Thread.currentThread().getName() + "............3");
                            return s + "_3";
                        })
                        .thenAccept(s -> {
                            System.out.println("有入参有返回值......." + s);
                            System.out.println(Thread.currentThread().getName() + "............4");
                        }).thenRun(() -> {
                            System.out.println("没有入参，没有返回值");
                            System.out.println(Thread.currentThread().getName() + "............4");
                        }).thenCompose(s -> {
                            System.out.println("Returns a new CompletionStage");
                            System.out.println(Thread.currentThread().getName() + "............5");
                            return CompletableFuture.supplyAsync(() -> {
                                System.out.println("new CompletionStage....");
                                return s + "_new_1";
                            }).thenAcceptAsync(a -> {
                                System.out.println(a + ".....1");
                                System.out.println(Thread.currentThread().getName() + "............1");
                            }).thenRunAsync(() -> {
                                System.out.println(Thread.currentThread().getName() + "............2");
                            }).thenApplyAsync(t -> {
                                System.out.println("t:如果上一个函数没有响应值，则参数为 null");
                                System.out.println(Thread.currentThread().getName() + "............3");
                                return t + "_new_2";
                            });
                        });

        System.out.println(f0.get());
    }

}
