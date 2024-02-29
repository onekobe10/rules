package com.gankki.demo.test.Exception;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class ExceptionTest111 {
        public static void main(String[] args) {
            int[] array = new int[3];
            System.out.println("1z");
            System.err.println(array[2]);
            System.out.println("1z1");
            System.out.println(array[5]);  // 这一行将抛出ArrayIndexOutOfBoundsException异常
        }

}
