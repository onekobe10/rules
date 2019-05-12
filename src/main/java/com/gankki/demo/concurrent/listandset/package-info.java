package com.gankki.demo.concurrent.listandset;

/**
 * 并发包中容器类	Copy-On-Write实现的list/set,CopyOnWriteArrayList/CopyOnWriteArraySet
 * 	它们的实现机制是Copy-On-Write，写时复制/写时拷贝，是解决并发问题的一种重要思路
 *
 *	CopyOnWriteArrayList实现了List接口，它的用法与其他List如ArrayList基本是一样的，它的区别是：
 * 		1.它是线程安全的，可以被多个线程并发访问
 * 		2.它的迭代器不支持修改操作，但也不会抛出ConcurrentModificationException
 * 		3.它以原子方式支持一些复合操作
 *
 *	private transient volatile Object[] array;
 *
 * 	CopyOnWriteArrayList的内部也是一个数组，但这个数组是以原子方式被整体更新的。
 * 	每次修改操作，都会新建一个数组，复制原数组的内容到新数组，
 * 	在新数组上进行需要的修改，然后以原子方式设置内部的数组引用，这就是写时拷贝。
 *
 * 	所有的读操作，都是先拿到当前引用的数组，然后直接访问该数组，
 * 	在读的过程中，可能内部的数组引用已经被修改了，但不会影响读操作，它依旧访问原数组内容。
 *
 *	换句话说，数组内容是只读的，写操作都是通过新建数组，然后原子性的修改数组引用来实现的。
 *
 *  在CopyOnWriteArrayList中，读不需要锁，可以并行，读和写也可以并行，
 *  但多个线程不能同时写，每个写操作都需要先获取锁，CopyOnWriteArrayList内部使用ReentrantLock 来实现显式锁
 *
 *	迭代器是内部类COWIterator实现的，传递给它的也是不变的数组，只读，不可以修改
 *		public Iterator<E> iterator() {
 *     		return new COWIterator<E>(getArray(), 0);
 * 		}
 *
 *	总结
 *	每次修改都创建一个新数组，然后复制所有内容，这听上去是一个难以令人接受的方案，如果数组比较大，修改操作又比较频繁，
 *	可以想象，CopyOnWriteArrayList的性能是很低的。事实确实如此，CopyOnWriteArrayList不适用于数组很大，且修改频繁的场景。
 *	它是以优化读操作为目标的，读不需要同步，性能很高，但在优化读的同时就牺牲了写的性能。
 *
 *	保证线程安全的几种思路，一种是锁，使用synchronized或ReentrantLock，另外一种是循环CAS，
 *	写时拷贝体现了保证线程安全的另一种思路。对于绝大部分访问都是读，且有大量并发线程要求读，
 *	只有个别线程进行写，且只是偶尔写的场合，这种写时拷贝就是一种很好的解决方案。
 *
 * 	写时拷贝是一种重要的思维，用于各种计算机程序中，比如经常用于操作系统内部的进程管理和内存管理。
 * 	在进程管理中，子进程经常共享父进程的资源，只有在写时才复制。
 * 	在内存管理中，当多个程序同时访问同一个文件时，操作系统在内存中可能只会加载一份，
 * 	只有程序要写时才会拷贝，分配自己的内存，拷贝可能也不会全部拷贝，而只会拷贝写的位置所在的页，
 * 	页是操作系统管理内存的一个单位，具体大小与系统有关，典型大小为4KB。
 *
 * 	CopyOnWriteArraySet	实现了Set接口，不包含重复元素，使用比较简单，我们就不赘述了。内部，它是通过CopyOnWriteArrayList实现的
 *	 add方法的实现，只要当数组中没有元素e时才会添加到数组中，保证了元素不重复。
 *		public boolean add(E e) {
 *         return al.addIfAbsent(e);
 *     }
 *
 *   由于CopyOnWriteArraySet是基于CopyOnWriteArrayList实现的，所以性能同样比较低，不适用于元素特别多的集合。
 *   如果元素个数比较多，可以考虑ConcurrentHashMap或ConcurrentSkipListSet
 *
 *	ConcurrentHashMap与HashMap类似，适用于不要求排序的场景，
 *	ConcurrentSkipListSet与TreeSet类似，适用于要求排序的场景。
 *	Java并发包中没有与HashSet对应的并发容器，但可以很容易的基于ConcurrentHashMap构建一个，利用Collections.newSetFromMap方法即可。
 *
 */