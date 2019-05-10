package com.gankki.demo.concurrent.atomic;

/**
 *	atomic variable & CAS 原子变量和CAS
 *
 * 	我们可以使用synchronized关键字来保证原子变量，但是使用synchronized成本太高了，
 * 	需要先获取锁，最后还要释放锁，获取不到锁的情况下还要等待，还会有线程的上下文切换，这些都需要成本。
 *
 *	对于这种情况，完全可以使用原子变量代替，Java并发包中的基本原子变量类型有：
 *		基本原子变量类型					数组原子变量类型			以原子方式更新对象中的字段
 *		AtomicBoolean：原子Boolean类型
 * 		AtomicInteger：原子Integer类型	AtomicIntegerArray		AtomicIntegerFieldUpdater
 * 		AtomicLong：原子Long类型			AtomicLongArray			AtomicLongFieldUpdater
 * 		AtomicReference：原子引用类型		AtomicReferenceArray	AtomicReferenceFieldUpdater	AtomicMarkableReference/AtomicStampedReference
 *
 *		AtomicBoolean	private volatile int value; 用1/0表示 true/false
 *			compareAndSet：return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
 *		AtomicInteger	private volatile int value;
 *			compareAndSet：return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
 *		AtomicLong		private volatile long value;
 *			compareAndSet：unsafe.compareAndSwapLong(this, valueOffset, expect, update);
 *  	AtomicReference	private volatile V value;
 *  		AtomicReference用来以原子方式更新复杂类型，它有一个类型参数，使用时需要指定引用的类型
 *			AtomicReference的CAS方法调用的是unsafe的另一个方法：
 *			compareAndSet：unsafe.compareAndSwapObject(this, valueOffset, expect, update);
 *	public final boolean compareAndSet(int expect, int update)
 *	这是一个非常重要的方法，比较并设置，我们以后将简称为CAS。
 *	该方法以原子方式实现了如下功能：如果当前值等于expect，则更新为update，否则不更新，如果更新成功，返回true，否则返回false。
 *
 *	***volatile 不稳定的，反复无常的	可以保证变量的内存可见性，即不会从缓存中取值。***
 *
 *	****
 *	悲观锁和乐观锁的应用：synchronized和cas
 *		synchronized是悲观的，它假定更新很可能冲突，所以先获取锁，得到锁后才更新。
 *		原子变量的更新逻辑是乐观的，它假定冲突比较少，但使用CAS更新，也就是进行冲突检测，如果确实冲突了，那也没关系，继续尝试就好了。
 *	****
 *	synchronized代表一种阻塞式算法，得不到锁的时候，进入锁等待队列，等待其他线程唤醒，有上下文切换开销。
 *	原子变量的更新逻辑是非阻塞式的，更新冲突的时候，它就重试，不会阻塞，不会有上下文切换开销。
 *  	原子变量中由于volatile关键字保证了内存可见性，所以每个线程获取到的变量都是最新的值。
 *
 *  对于大部分比较简单的操作，无论是在低并发还是高并发情况下，这种乐观非阻塞方式的性能都要远高于悲观阻塞式方式。
 *	原子变量是比较简单的，但对于复杂一些的数据结构和算法，非阻塞方式往往难于实现和理解，
 *	幸运的是，Java并发包中已经提供了一些非阻塞容器，我们只需要会使用就可以了，比如：
 * 		ConcurrentLinkedQueue和ConcurrentLinkedDeque：非阻塞并发队列
 * 		ConcurrentSkipListMap和ConcurrentSkipListSet：非阻塞并发Map和Set
 *
 * 	sun.misc.unsafe
 * 		原理上，一般的计算机系统都在硬件层次上直接支持CAS指令，而Java的实现都会利用这些特殊指令。
 * 		从程序的角度看，我们可以将compareAndSet视为计算机的基本操作，直接接纳就好。
 *
 * 	基于CAS，除了可以实现乐观非阻塞算法，它也可以用来实现悲观阻塞式算法，
 * 	比如锁，实际上，Java并发包中的所有阻塞式工具、容器、算法也都是基于CAS的 (不过，也需要一些别的支持)。参考MyLock
 *
 *	原子数组：原子数组方便以原子的方式更新数组中的每个元素
 *
 *	FieldUpdater：FieldUpdater方便以原子方式更新对象中的字段，字段不需要声明为原子变量，FieldUpdater是基于反射机制实现的
 *
 *	ABA问题：
 *		该问题是指，一个线程开始看到的值是A，随后使用CAS进行更新，它的实际期望是没有其他线程修改过才更新，
 *		但普通的CAS做不到，因为可能在这个过程中，已经有其他线程修改过了，比如先改为了B，然后又改回为了A。
 *	ABA是不是一个问题与程序的逻辑有关，如果是一个问题，一个解决方法是使用AtomicStampedReference，
 *	在修改值的同时附加一个时间戳，只有值和时间戳都相同才进行修改，其CAS方法声明为：
 *	public boolean compareAndSet(V expectedReference, V newReference, int expectedStamp, int newStamp)
 *
 * 	AtomicMarkableReference是另一个AtomicReference的增强类，与AtomicStampedReference类似，
 * 	它也是给引用关联了一个字段，只是这次是一个boolean类型的标志位，只有引用值和标志位都相同的情况下才进行修改。
 *
 * 	总结：
 * 		对于并发环境中的计数、产生序列号等需求，考虑使用原子变量而非锁，
 * 		CAS是Java并发包的基础，基于它可以实现高效的、乐观、非阻塞式数据结构和算法，它也是并发包中锁、同步工具和各种容器的基础。
 */