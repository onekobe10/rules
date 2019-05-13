package com.gankki.demo.concurrent.concurrenthashmap;

/**
 * 并发包中容器类	ConcurrentHashMap
 *
 * ConcurrentHashMap，它是HashMap的并发版本，与HashMap相比，它有如下特点：
 * 	1.并发安全
 * 	2.直接支持一些原子复合操作
 * 	3.支持高并发、读操作完全并行、写操作支持一定程度的并行
 *  4.与同步容器Collections.synchronizedMap相比，迭代不用加锁，不会抛出ConcurrentModificationException
 *  5.弱一致性
 *
 *	HashMap不是并发安全的，在并发更新的情况下，HashMap的链表结构可能形成环，出现死循环，占满CPU
 *
 *	public class ConcurrentHashMap<K,V> extends AbstractMap<K,V>
 *     implements ConcurrentMap<K,V>, Serializable
 *
 *	ConcurrentMap中定义的方法都是原子操作
 *
 *	ConcurrentHashMap是为高并发设计的，具体实现比较复杂，主要有两点
 *		1.分段锁
 *	    2.读不需要锁
 *
 *	 同步容器使用synchronized，所有方法，竞争同一个锁，而ConcurrentHashMap采用分段锁技术，
 *	 将数据分为多个段，而每个段有一个独立的锁，每一个段相当于一个独立的哈希表，分段的依据也是哈希值，
 *	 无论是保存键值对还是根据键查找，都先根据键的哈希值映射到段，再在段对应的哈希表上进行操作。
 *
 *	采用分段锁，可以大大提高并发度，多个段之间可以并行读写。
 *	默认情况下，段是16个，不过，这个数字可以通过构造方法进行设置，如下所示：
 *  public ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)
 *	concurrencyLevel表示估计的并行更新的线程个数，ConcurrentHashMap会将该数转换为2的整数次幂，比如14转换为16，25转换为32。
 *
 *	***在对每个段的数据进行读写时，ConcurrentHashMap也不是简单的使用锁进行同步，内部使用了CAS、对一些写采用原子方式，
 *	实现比较复杂，实现的效果是，对于写操作，需要获取锁，不能并行，但是读操作可以，多个读可以并行，
 *	写的同时也可以读，这使得ConcurrentHashMap的并行度远远大于同步容器。***
 *
 *	使用同步容器，在迭代中需要加锁，否则可能会抛出ConcurrentModificationException。
 *	ConcurrentHashMap没有这个问题，在迭代器创建后，在迭代过程中，如果另一个线程对容器进行了修改，迭代会继续，不会抛出异常。
 *
 *	ConcurrentHashMap的迭代器创建后，就会按照哈希表结构遍历每个元素，但在遍历过程中，内部元素可能会发生变化，
 *	如果变化发生在已遍历过的部分，迭代器就不会反映出来，而如果变化发生在未遍历过的部分，迭代器就会发现并反映出来，这就是弱一致性。
 *	参考ConcurrentHashMapIteratorDemo
 *
 * 	类似的情况还会出现在ConcurrentHashMap的另一个方法：
 * 		//批量添加m中的键值对到当前Map
 * 		public void putAll(Map<? extends K, ? extends V> m)
 *	该方法并非原子操作，而是调用put方法逐个元素进行添加的，在该方法没有结束的时候，部分修改效果就会体现出来。
 *
 *	总结
 *		ConcurrentHashMap，它是并发版的HashMap，通过分段锁和其他技术实现了高并发，支持原子条件更新操作，不会抛出ConcurrentModificationException，实现了弱一致性。
 *
 * 		Java中没有并发版的HashSet，但可以通过Collections.newSetFromMap方法基于ConcurrentHashMap构建一个。
 *
 * 		我们知道HashMap/HashSet基于哈希，不能对元素排序，对应的可排序的容器类是TreeMap/TreeSet，
 * 		并发包中可排序的对应版本不是基于树，而是基于Skip List（跳跃表）的，类分别是ConcurrentSkipListMap和ConcurrentSkipListSet
 *
 *
 */