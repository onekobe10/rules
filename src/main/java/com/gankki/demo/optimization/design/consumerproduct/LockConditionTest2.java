package com.gankki.demo.optimization.design.consumerproduct;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuhao
 * @date 2020/3/22
 */
public class LockConditionTest2 {

    private LinkedList<String> product = new LinkedList<>();
    private AtomicInteger inventory = new AtomicInteger(0);//实时库存

    private int maxInventory = 10; // 最大库存

    private Lock consumerLock = new ReentrantLock();// 资源锁
    private Lock productLock = new ReentrantLock();// 资源锁

    private Condition notEmptyCondition = consumerLock.newCondition();// 库存满和空条件
    private Condition notFullCondition = productLock.newCondition();// 库存满和空条件

    /**
     * 新增商品库存
     *
     * @param e
     */
    public void produce(String e) {
        productLock.lock();
        try {
            while (inventory.get() == maxInventory) {
                notFullCondition.await();
            }

            product.add(e);

            System.out.println("放入一个商品库存，总库存为：" + inventory.incrementAndGet());

            if (inventory.get() < maxInventory) {
                notFullCondition.signalAll();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            productLock.unlock();
        }

        if (inventory.get() > 0) {
            try {
                consumerLock.lockInterruptibly();
                notEmptyCondition.signalAll();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                consumerLock.unlock();
            }
        }

    }

    /**
     * 消费商品
     *
     * @return
     */
    public String consume() {
        String result = null;
        consumerLock.lock();
        try {
            while (inventory.get() == 0) {
                notEmptyCondition.await();
            }

            result = product.removeLast();
            System.out.println("消费一个商品，总库存为：" + inventory.decrementAndGet());

            if (inventory.get() > 0) {
                notEmptyCondition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumerLock.unlock();
        }

        if (inventory.get() < maxInventory) {

            try {
                productLock.lockInterruptibly();
                notFullCondition.signalAll();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } finally {
                productLock.unlock();
            }
        }
        return result;
    }

    /**
     * 生产者
     *
     * @author admin
     */
    private class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                produce("商品" + i);
            }
        }
    }

    /**
     * 消费者
     *
     * @author admin
     */
    private class Customer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                consume();
            }
        }
    }

    public static void main(String[] args) {

        LockConditionTest2 lc = new LockConditionTest2();
        new Thread(lc.new Producer()).start();
        new Thread(lc.new Customer()).start();

    }
}
