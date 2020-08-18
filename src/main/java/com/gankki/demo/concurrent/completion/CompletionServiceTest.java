package com.gankki.demo.concurrent.completion;

import java.util.concurrent.*;

/**
 * CompletionService：批量执行异步任务
 *
 * @author liuhao
 * @date 2020/8/18
 */
public class CompletionServiceTest {

    /**
     * CompletionService 实现的批量异步处理
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 创建线程池 --> 根据实际情况创建独立的线程池，避免线程饥饿
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // 创建阻塞队列 --> 如果没有手动创建阻塞队列指定长度，将创建 Integer.MAX_VALUE，无界阻塞队列
        // 队列中放置的是 Future 对象
        BlockingQueue<Future<Integer>> bq =
                new LinkedBlockingQueue<>(3);

        // 创建CompletionService
        CompletionService<Integer> cs = new
                ExecutorCompletionService<>(executor, bq);

        // 异步向电商S1询价
        cs.submit(() -> getPriceByS1());
        // 异步向电商S2询价
        cs.submit(() -> getPriceByS2());
        // 异步向电商S3询价
        cs.submit(() -> getPriceByS3());

        // 将询价结果异步保存到数据库
        for (int i = 0; i < 3; i++) {
            // 如果队列中为空，队列会阻塞，如果有线程执行完毕，队列会被唤醒处理。
            Integer r = cs.take().get();
            // 最后根据情况异步处理线程返回的批量结果
            executor.execute(() -> save(r));
        }
    }

    /**
     * 传统的借助于阻塞队列实现的批量处理
     * @throws Exception
     */
    private void tradtion() throws Exception {
        // 创建阻塞队列
        BlockingQueue<Integer> bq =
                new LinkedBlockingQueue<>(3);
        //电商S1报价异步进入阻塞队列
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
        executor.execute(() -> {
            Integer f1 = getPriceByS1();
            try {
                bq.put(f1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //电商S2报价异步进入阻塞队列
        executor.execute(() -> {
            Integer f2 = getPriceByS2();
            try {
                bq.put(f2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //电商S3报价异步进入阻塞队列
        executor.execute(() -> {
            Integer f3 = getPriceByS3();
            try {
                bq.put(f3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //异步保存所有报价
        for (int i = 0; i < 3; i++) {
            Integer r = bq.take();
            executor.execute(() -> save(r));
        }
    }

    private static Integer getPriceByS1() {
        System.out.println("询价1....." + Thread.currentThread().getName());
        return 1;
    }

    private static Integer getPriceByS2() {
        System.out.println("询价2....." + Thread.currentThread().getName());
        return 2;
    }

    private static Integer getPriceByS3() {
        System.out.println("询价3....." + Thread.currentThread().getName());
        return 3;
    }

    private static void save(Integer r) {
        System.out.println("保存询价....." + r + "...." + Thread.currentThread().getName());
    }

}
