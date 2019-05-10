package com.gankki.demo.concurrent.Interrupt;

/**
 *	interrupt introduction 线程中断的介绍
 *
 *	stop方法已经过时了，不建议使用。
 *	在Java中，停止一个线程的主要机制是中断，中断并不是强迫终止一个线程，它是一种协作机制，
 *	是给线程传递一个取消信号，但是由线程来决定如何以及何时退出。
 *
 *	isInterrupted()和interrupt()是实例方法,interrupted()是静态方法，实际会调用Thread.currentThread()操作当前线程。
 * 		isInterrupted 就是返回对应线程的中断标志位是否为true。
 * 		interrupted	返回当前线程的中断标志位是否为true，但它还有一个重要的副作用，
 * 			就是清空中断标志位，也就是说，连续两次调用interrupted()，
 * 			第一次返回的结果为true，第二次一般就是false (除非同时又发生了一次中断)。
 * 		interrupt	表示中断对应的线程
 * 	interrupt()对线程的影响与线程的状态和在进行的IO操作有关，我们先主要考虑线程的状态：
 * 		RUNNABLE：线程在运行或具备运行条件只是在等待操作系统调度
 * 		WAITING/TIMED_WAITING：线程在等待某个条件或超时
 * 		BLOCKED：线程在等待锁，试图进入同步块
 * 		NEW/TERMINATED：线程还未启动或已结束
 *
 *	***如果线程在运行中，且没有执行IO操作，interrupt()只是会设置线程的中断标志位，没有任何其它作用。线程应该在运行过程中合适的位置检查中断标志位***
 *
 * 	线程执行如下方法会进入WAITING状态：
 *		public final void join() throws InterruptedException
 * 		public final void wait() throws InterruptedException
 * 	执行如下方法会进入TIMED_WAITING状态：
 * 		public final native void wait(long timeout) throws InterruptedException;
 * 		public static native void sleep(long millis) throws InterruptedException;
 * 		public final synchronized void join(long millis) throws InterruptedException
 *	在这些状态时，对线程对象调用interrupt()会使得该线程抛出InterruptedException，
 *	需要注意的是，抛出异常后，中断标志位会被清空，而不是被设置。
 * 	InterruptedException是一个受检异常，线程必须进行处理。
 * 	处理异常的基本思路是，如果你知道怎么处理，就进行处理，如果不知道，就应该向上传递，通常情况下，你不应该做的是，捕获异常然后忽略。
 *
 * 	捕获到InterruptedException，通常表示希望结束该线程，线程大概有两种处理方式：
 * 		1.向上传递该异常，这使得该方法也变成了一个可中断的方法，需要调用者进行处理。
 * 		2.有些情况，不能向上传递异常，比如Thread的run方法，它的声明是固定的，不能抛出任何受检异常，
 * 		这时，应该捕获异常，进行合适的清理操作，清理后，一般应该调用Thread的interrupt方法设置中断标志位，
 * 		使得其他代码有办法知道它发生了中断。
 *
 *	***如果线程在等待锁，对线程对象调用interrupt()只是会设置线程的中断标志位，线程依然会处于BLOCKED状态，
 *	也就是说，interrupt()并不能使一个在等待锁的线程真正"中断"。***
 *
 * 	如果线程尚未启动(NEW)，或者已经结束(TERMINATED)，则调用interrupt()对它没有任何效果，中断标志位也不会被设置。
 *
 *	如果线程在等待IO操作，尤其是网络IO，则会有一些特殊的处理：
 *		1.如果IO通道是可中断的，即实现了InterruptibleChannel接口，则线程的中断标志位会被设置，
 *		同时，线程会收到异常ClosedByInterruptException。
 *		2.如果线程阻塞于Selector调用，则线程的中断标志位会被设置，同时，阻塞的调用会立即返回。
 *		3.InputStream的read调用，该操作是不可中断的，如果流中没有数据，
 *		read会阻塞 (但线程状态依然是RUNNABLE)，且不响应interrupt(),
 *		与synchronized类似，调用interrupt()只会设置线程的中断标志，而不会真正"中断"它。
 *	总结：
 *		在Java中如何取消/关闭线程，主要依赖的技术是中断，但它是一种协作机制，不会强迫终止线程，
 *		作为线程的实现者，应该提供明确的取消/关闭方法，并用文档描述清楚其行为，作为线程的调用者，应该使用其取消/关闭方法，而不是贸然调用interrupt。
 *
 *
 */