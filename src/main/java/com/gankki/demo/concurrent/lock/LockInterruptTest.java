package com.gankki.demo.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以响应中断的锁
 *
 * @author liuhao
 * @date 2020/8/19
 */
public class LockInterruptTest {

    private ReentrantLock rlock = new ReentrantLock();

    private void lockTest2() {
        long currentTime = System.currentTimeMillis();
        try {
            rlock.lock();

            System.out.println("lockTest----current thread get the lock: " + Thread.currentThread().getName());

            while (System.currentTimeMillis() - currentTime <= 5000) {
                //assume do something
            }

        } finally {
            rlock.unlock();
            System.out.println("lockTest----current thread release the lock:  " + Thread.currentThread().getName());
        }
    }

    private void tryLockInterruptTest() {

        long currentTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - currentTime <= 100) {
            //assume do something
        }

        try {
            System.out.println("Begin time: " + System.currentTimeMillis());
            if (rlock.tryLock(3, TimeUnit.SECONDS)) {
                try {
                    System.out.println("tryLockInterruptTest----current thread get the lock: " + Thread.currentThread().getName());
                } finally {
                    rlock.unlock();
                    System.out.println("tryLockInterruptTest----current thread release the lock: " + Thread.currentThread().getName());
                }

            } else {
                System.out.println("End time: " + System.currentTimeMillis());
                System.out.println("tryLockInterruptTest----current thread CAN NOT get the lock: " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            System.out.println("tryLockInterruptTest Interrupt----current thread is interrupted: " + Thread.currentThread().getName());
        }
    }

    private void lockInterruptiblyTest() {

        try {
            rlock.lockInterruptibly();
        } catch (InterruptedException e) {
            System.out.println("该方法可以中断线程");
        } finally {
            rlock.unlock();
            System.out.println("tryLockInterruptTest----current thread release the lock: " + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {

        LockInterruptTest lockAndTryLock = new LockInterruptTest();

        Thread lockThread = new Thread(
                () -> lockAndTryLock.lockTest2(), "Lock-Thread");

        Thread tryLockInterruptThread = new Thread(
                () -> lockAndTryLock.tryLockInterruptTest(), "TryLockInterrupt-Thread"
        );

        Thread LockInterruptiblity = new Thread(
                () -> lockAndTryLock.lockInterruptiblyTest(), "LockInterruptiblity"
        );


        lockThread.start();
        LockInterruptiblity.start();

        // 可以中断处于Lock处于等待中的线程，以及可以中断执行中的线程。
        LockInterruptiblity.interrupt();




    }

}

