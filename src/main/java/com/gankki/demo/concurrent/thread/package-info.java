package com.gankki.demo.concurrent.thread;

/**
 * thread introduction 线程介绍
 *
 * 线程表示一条单独的执行流，它有自己的程序执行计数器，有自己的栈。
 * run方法的方法签名是固定的，public，没有参数，没有返回值，不能抛出受检异常。
 * 	run方法类似于单线程程序中的main方法，线程从run方法的第一条语句开始执行直到结束。
 *
 * 为什么调用的是start，执行的却是run方法呢？
 * 	start表示启动该线程，使其成为一条单独的执行流，背后，操作系统会分配线程相关的资源，每个线程会有单独的程序执行计数器和栈，
 * 	操作系统会把这个线程作为一个独立的个体进行调度，分配时间片让它执行，执行的起点就是run方法。
 *
 * 如果不调用start，而直接调用run方法呢？屏幕的输出并不会发生变化，
 * 	但并不会启动一条单独的执行流，run方法的代码依然是在main线程中执行的，run方法只是main方法调用的一个普通方法。
 *
 * 成本
 * 	关于线程，我们需要知道，它是有成本的。创建线程需要消耗操作系统的资源，操作系统会为每个线程创建必要的数据结构、栈、程序计数器等，创建也需要一定的时间。
 * 	线程调度和切换也是有成本的，当有当量可运行线程的时候，操作系统会忙于调度，为一个线程分配一段时间，执行完后，再让另一个线程执行，
 * 	一个线程被切换出去后，操作系统需要保存它的当前上下文状态到内存，上下文状态包括当前CPU寄存器的值、程序计数器的值等，
 * 	而一个线程被切换回来后，操作系统需要恢复它原来的上下文状态，整个过程被称为 上下文切换 ，这个切换不仅耗时，而且使CPU中的很多缓存失效，是有成本的。
 *
 * 线程的六个状态：enum State NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED
 *
 * 	创建线程的三种方式
 * 	  1.继承Thread类，重写run方法。
 * 	  	缺点：java是单继承的，如果有了父类就不能继承Thread对象了。
 * 	  2.实现Runnable接口，创建一个Thread对象，传递一个Runnable对象来启动线程。
 * 	  	缺点：Runnable接口实现的线程方法，不能有返回值，不能抛出受检异常
 * 	  3.实现Callable接口，可以有返回值，可以抛出受检异常。jdk1.5
 * 	  	 使用FutureTask对象来包装Callable接口的实现类，FutureTask对象实现了Runnable接口，可以将其作为target放入到Thread中，
 * 	  	 FutureTask对象在它的run方法中调用了Callable接口的实现类的call方法。可以调用FutureTask对象get方法返回call方法的返回值。
 * 	  	 层层包装 装饰模式的应用
 *
 *	Thread.yield()，yield 屈服，放弃，让步 。 不能抛出中断异常
 *		只是告诉操作系统的调度器可以先让其他线程运行，如果调度器没有分配资源给其他线程，那么当前线程依然是运行状态。
 *		也就是让出当前线程的可运行资源给其他线程，但是是随机的，不一定让出，由操作系统决定的调度器决定。
 *
 *  Thread.sleep(long millis) throws InterruptedException
 * 		让当前线程睡眠一段时间，在睡眠的过程中，不会失去锁和其他资源。
 *
 */