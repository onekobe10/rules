package com.gankki.demo.test.Exception;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class ExceptionTest2 {
        public static void main(String[] args) {
            CompletableFuture.runAsync(() -> {
                try {
                    int[] array = new int[3];
                    System.out.println(array[5]);  // 这一行将抛出ArrayIndexOutOfBoundsException异常
                } catch (Exception e) {
                    System.err.println("Caught an exception: " + e.getMessage());
                }
            });

        }

}
