package com.gankki.demo.thread.test6;

public class SynchronizedDemo2 {
 
     public static synchronized void method1(){
         System.out.println("进入方法1");
         try {
            System.out.println("方法1执行");
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("方法1 end");
     }
     
     public static synchronized void method2(){
         System.out.println("进入方法2");
         try {
             System.out.println("方法2执行");
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("方法2 end");
     }
         
     public static void main(String[] args) {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 SynchronizedDemo2.method1();
             }
         }).start();
        
         new Thread(new Runnable() {
             @Override
             public void run() {
                 SynchronizedDemo2.method2();
             }
         }).start();
     }
 }
