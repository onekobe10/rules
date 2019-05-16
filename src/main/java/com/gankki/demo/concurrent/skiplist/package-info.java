package com.gankki.demo.concurrent.skiplist;

/**
 * 	并发包中可排序的对应版本不是基于树，而是基于Skip List（跳跃表）的，类分别是ConcurrentSkipListMap和ConcurrentSkipListSet
 *
 *	TreeSet是基于TreeMap实现的，与此类似，ConcurrentSkipListSet也是基于ConcurrentSkipListMap实现的
 *
 *	ConcurrentSkipListMap是基于SkipList实现的，SkipList称为跳跃表或跳表，是一种数据结构，
 *	并发版本为什么采用跳表而不是树呢？原因也很简单，**因为跳表更易于实现高效并发算法。** 非常复杂
 *
 *	ConcurrentSkipListMap有如下特点：
 * 		1.没有使用锁，所有操作都是无阻塞的，所有操作都可以并行，包括写，多个线程可以同时写。
 * 		2.与ConcurrentHashMap类似，迭代器不会抛出ConcurrentModificationException，是弱一致的，
 * 			迭代可能反映最新修改也可能不反映，一些方法如putAll, clear不是原子的。
 * 		3.与ConcurrentHashMap类似，同样实现了ConcurrentMap接口，直接支持一些原子复合操作。
 * 		4.与TreeMap一样，可排序，默认按键自然有序，可以传递比较器自定义排序，实现了SortedMap和NavigableMap接口。
 *
 *	ConcurrentSkipListMap的排序方法与TreeMap类似，原子复合操作与ConcurrentHashMap类似
 *
 *	需要说明一下的是它的size方法，与大多数容器实现不同，这个方法不是常量操作，它需要遍历所有元素，
 *	复杂度为O(N)，而且遍历结束后，元素个数可能已经变了，一般而言，在并发应用中，这个方法用处不大。
 *
 *	对于常见的操作，如get/put/remove/containsKey，ConcurrentSkipListMap的复杂度都是O(log(N))。
 *
 * 	ConcurrentSkipListMap和ConcurrentSkipListSet，它们基于跳表实现，有序，无锁非阻塞，完全并行，主要操作复杂度为O(log(N))。
 *
 *
 */