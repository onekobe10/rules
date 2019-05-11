package com.gankki.demo.concurrent.lock;

/**
 *	Lock 显式锁
 *		lock()/unlock()：就是普通的获取锁和释放锁方法，lock()会阻塞直到成功。
 * 		lockInterruptibly()：与lock()的不同是，它可以响应中断，如果被其他线程中断了，抛出InterruptedException。
 * 		tryLock()：只是尝试获取锁，立即返回，不阻塞，如果获取成功，返回true，否则返回false。
 * 		tryLock(long time, TimeUnit unit) ：先尝试获取锁，如果能成功则立即返回true，
 * 			否则阻塞等待，但等待的最长时间为指定的参数，在等待的同时响应中断，如果发生了中断，抛出InterruptedException，
 * 			如果在等待的时间内获得了锁，返回true，否则返回false。
 * 		newCondition：新建一个条件，一个Lock可以关联多个条件
 *	显式锁相比synchronized，支持以非阻塞方式获取锁、可以响应中断、可以限时，这使得它灵活的多。
 *
 *	锁接口Lock，主要实现类是可重入锁 ReentrantLock	读写锁接口ReadWriteLock，主要实现类是ReentrantReadWriteLock
 *	Lock接口的主要实现类是ReentrantLock，它的基本用法lock/unlock实现了与synchronized一样的语义，包括：
 * 		1.可重入，一个线程在持有一个锁的前提下，可以继续获得该锁
 * 		2.可以解决竞态条件问题
 * 		3.可以保证内存可见性
 *	ReentrantLock可以使用tryLock()方法避免死锁，在原理上使用CAS、LockSupport和AQS来实现
 *
 *	public ReentrantLock(boolean fair)
 *	参数fair表示是否保证公平，不指定的情况下，默认为false，表示不保证公平。
 *	所谓公平是指，等待时间最长的线程优先获得锁。
 *	保证公平会影响性能，一般也不需要，所以默认不保证，synchronized锁也是不保证公平的
 *
 *  使用显式锁，一定要记得调用unlock，一般而言，应该将lock之后的代码包装到try语句内，在finally语句内释放锁
 *
 * ReentrantLock中其他的一些方法介绍：
 *  使用tryLock()，可以避免死锁。在持有一个锁，获取另一个锁，获取不到的时候，
 *  可以释放已持有的锁，给其他线程机会获取锁，然后再重试获取所有锁。参考AccountMgr
 *
 *	//锁是否被持有，只要有线程持有就返回true，不一定是当前线程持有
 * 	public boolean isLocked()
 *
 *	 //锁是否被当前线程持有
 * 	public boolean isHeldByCurrentThread()
 *
 * 	//***锁被当前线程持有的数量，即调用lock()方法的次数。0表示不被当前线程持有***
 * 	public int getHoldCount()
 *
 * 	 //锁等待策略是否公平
 *  public final boolean isFair()
 *
 * 	//是否有线程在等待该锁
 * 	public final boolean hasQueuedThreads()
 *
 * 	//指定的线程thread是否在等待该锁
 * 	public final boolean hasQueuedThread(Thread thread)
 *
 * 	//在等待该锁的线程个数
 * 	public final int getQueueLength()
 *
 *	实现原理
 *		在最底层，它依赖于CAS方法，另外，它依赖于类LockSupport中的一些方法。
 *		park使得当前线程放弃CPU，进入等待状态(WAITING)，操作系统不再对它进行调度，什么时候再调度呢？
 *		有其他线程对它调用了unpark，unpark需要指定一个线程，unpark会使之恢复可运行状态。
 *		park不同于Thread.yield()，yield只是告诉操作系统可以先让其他线程运行，但自己依然是可运行状态，
 *		而park会放弃调度资格，使线程进入WAITING状态。
 *		需要说明的是，park是响应中断的，当有中断发生时，park会返回，线程的中断状态会被设置。
 *		另外，还需要说明一下，park可能会无缘无故的返回，程序应该重新检查park等待的条件是否满足。
 *		park有两个变体：
 * 			parkNanos：可以指定等待的最长时间，参数是相对于当前时间的纳秒数。
 * 			parkUntil：可以指定最长等到什么时候，参数是绝对时间，是相对于纪元时的毫秒数。
 * 			当等待超时的时候，它们也会返回。
 * 			LockSupport有一个方法，可以返回一个线程的blocker对象：public static Object getBlocker(Thread t)
 *			与CAS方法一样，它们也调用了Unsafe类中的对应方法，Unsafe类最终调用了操作系统的API，
 *			从程序员的角度，我们可以认为LockSupport中的这些方法就是基本操作。
 *
 *	利用CAS和LockSupport提供的基本方法，就可以用来实现ReentrantLock了。
 *	但Java中还有很多其他并发工具，如ReentrantReadWriteLock、Semaphore、CountDownLatch，
 *	它们的实现有很多类似的地方，为了复用代码，Java提供了一个抽象类AbstractQueuedSynchronizer，我们简称为AQS，它简化了并发工具的实现。
 *	用于实现锁时，AQS可以保存锁的当前持有线程，提供了方法进行查询和设置
 *	AQS内部维护了一个等待队列，借助CAS方法实现了无阻塞算法进行更新。
 *
 * 	为什么默认不保证公平呢？保证公平整体性能比较低，低的原因不是检查等待时间最长的线程慢，而是会让活跃线程得不到锁，
 * 		进入等待状态，引起上下文切换，降低了整体的效率，通常情况下，谁先运行关系不大，
 * 		而且长时间运行，从统计角度而言，虽然不保证公平，也基本是公平的。
 *
 *	需要说明是，即使fair参数为true，ReentrantLock中不带参数的tryLock方法也是不保证公平的，
 *		它不会检查是否有其他等待时间更长的线程，其代码为：
 *		public boolean tryLock() {
 *     		return sync.nonfairTryAcquire(1);
 * 		}
 *	ReentrantLock使用state表示是否被锁和持有数量，如果当前未被锁定，则立即获得锁，否则调用acquire(1)获得锁，acquire是AQS中的方法
 *	state The synchronization state 是 AQS中 的一个int属性，state默认为0，lock时会加1，unlock时减1	。
 * 	相比synchronized，ReentrantLock可以实现与synchronized相同的语义
 * 		但还支持以非阻塞方式获取锁、可以响应中断、可以限时等，更为灵活。
 * 	不过，synchronized的使用更为简单，写的代码更少，也更不容易出错。
 *
 * 	synchronized代表一种声明式编程，程序员更多的是表达一种同步声明，由Java系统负责具体实现，
 * 	程序员不知道其实现细节，显式锁代表一种命令式编程，程序员实现所有细节。
 *
 *  声明式编程的好处除了简单，还在于性能，在较新版本的JVM上，ReentrantLock和synchronized的性能是接近的，
 *  	但Java编译器和虚拟机可以不断优化synchronized的实现，比如，自动分析synchronized的使用，
 *  	对于没有锁竞争的场景，自动省略对锁获取/释放的调用。
 *
 * 	简单总结，能用synchronized就用synchronized，不满足要求，再考虑ReentrantLock。
 *
 *	abstract static class Sync extends AbstractQueuedSynchronizer
 *	static final class NonfairSync extends Sync
 *  static final class FairSync extends Sync
 *
 *  ReentrantLock默认实现是NonfairSync实现，NonfairSync的lock方法实现，会先CAS去获取锁，如果获取不到才会将线程封装成Node对象，
 *  放到等待队列的尾部，只要放到了等待队列中，每次获取锁的都是队列头部的Node对象。
 *  而FairSync的lock实现中没有先CAS获取锁，直接放到了队列中去，就成了按顺序获取锁了，所以公平。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */