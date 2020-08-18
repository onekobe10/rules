package com.gankki.demo.concurrent.completion;

import java.util.concurrent.CompletableFuture;

/**
 * 异常处理
 *
 * @author liuhao
 * @date 2020/8/18
 */
public class ExceptionTest {

    /**
     * CompletableFuture 异常处理
     * @author liuhao
     * @date 2020/8/18
     */
    public static void main(String[] args) {
        CompletableFuture<Integer> exceptionFuture = CompletableFuture
                .supplyAsync(() -> 7 / 0)
                .thenApplyAsync(r -> r * 10)
                .exceptionally(e -> {
                    System.out.println("打印异常信息：" + e);
                    return 0;
                });

        System.out.println(exceptionFuture.join());
    }

}
