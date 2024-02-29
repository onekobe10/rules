package com.gankki.demo.test.Exception;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class ExceptionTest1 {
        public static void main(String[] args) {
            CompletableFuture<Void> future =  CompletableFuture.runAsync(() -> {
                int[] array = new int[3];
                System.out.println(array[5]);  // 这一行将抛出ArrayIndexOutOfBoundsException异常
            }, getThreadPoolTaskExecutor());
            // 等待异步任务完成
            future.join();
        }

    public static ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(100);
        executor.setThreadNamePrefix("主线程池-");
        executor.setAllowCoreThreadTimeOut(true);
        executor.setAwaitTerminationSeconds(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

}
