package com.gankki.demo.concurrent.condition;

/**
 * 	Condition 显式条件
 *
 *	锁用于解决竞态条件问题，条件是线程间的协作机制。显式锁与synchronized相对应，而显式条件与wait/notify相对应。
 *	wait/notify与synchronized配合使用，显式条件与显式锁配合使用。
 *
 *	Condition中的await()对应于Object的wait()，signal()对应于notify，signalAll()对应于notifyAll()，语义也是一样的。
 *	await重载方法都是响应中断的，如果发生了中断，会抛出InterruptedException，但中断标志位会被清空。
 *	Condition还定义了一个不响应中断的等待方法：void awaitUninterruptibly();
 *	该方法不会由于中断结束，但当它返回时，如果等待过程中发生了中断，中断标志位会被设置。
 *
 *	一般而言，与Object的wait方法一样，调用await方法前需要先获取锁，如果没有锁，会抛出异常IllegalMonitorStateException。
 * 		await在进入等待队列后，会释放锁，释放CPU，当其他线程将它唤醒后，或等待超时后，
 * 		或发生中断异常后，它都需要重新获取锁，获取锁后，才会从await方法中退出。
 *
 * 	另外，与Object的wait方法一样，await返回后，不代表其等待的条件就一定满足了，通常要将await的调用放到一个循环内，只有条件满足后才退出。
 *
 * 	一般而言，signal/signalAll与notify/notifyAll一样，调用它们需要先获取锁，
 * 		如果没有锁，会抛出异常IllegalMonitorStateException。
 * 		signal与notify一样，挑选一个线程进行唤醒，signalAll与notifyAll一样，唤醒所有等待的线程，
 * 		但这些线程被唤醒后都需要重新竞争锁，获取锁后才会从await调用中返回。
 *
 * 	不要将signal/signalAll与notify/notifyAll混淆，notify/notifyAll是Object中定义的方法，Condition对象也有，稍不注意就会误用。
 *
 * 	***显式条件与显式锁配合，wait/notify与synchronized配合。***
 *
 * 	ReentrantLock中的显式条件
 *		final ConditionObject newCondition() {
 *     		return new ConditionObject();
 * 		}
 * 	ConditionObject是AQS中定义的一个内部类，内部也有一个队列，表示条件等待队列
 * 	ConditionObject是AQS的成员内部类，它可以直接访问AQS中的数据，比如AQS中定义的锁等待队列，因此可以将一个线程从条件等待队列转移到锁等待队列
 *
 *	基于AQS实现的锁，条件等待队列和锁等待队列的数据结构是相同的，都是Node对象，每次添加在tail，获取在head，是一个双向链表，而不是数组。
 *
 *	总结
 *		显式条件与显式锁配合使用，与wait/notify相比，可以支持多个条件队列，代码更为易读，效率更高，使用时注意不要将signal/signalAll误写为notify/notifyAll。
 */