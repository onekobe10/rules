# Thread pool 线程池
线程池，顾名思义，就是一个线程的池子，里面有若干线程，它们的目的就是执行提交给线程池的任务，执行完一个任务后不会退出，而是继续等待或执行新任务。线程池主要由两个概念组成，一个是任务队列，另一个是工作者线程，工作者线程主体就是一个循环，循环从队列中接受任务并执行，任务队列保存待执行的任务。

#### 线程池的优点是显而易见的：
1. 它可以重用线程，避免线程创建的开销
2. 在任务过多时，通过排队避免创建过多线程，减少系统资源消耗和竞争，确保任务有序完成

Java并发包中线程池的实现类是ThreadPoolExecutor，它继承自AbstractExecutorService，实现了ExecutorService

```
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler)
```

1. corePoolSize     核心线程个数
2. maximumPoolSize  最大线程个数      
    maximumPoolSize表示线程池中的最多线程数，线程的个数会动态变化，但这是最大值，不管有多少任务，都不会创建比这个值大的线程个数。
3. keepAliveTime    空闲线程存活时间        
4. unit             keepAliveTime的单位    MILLISECONDS    NANOSECONDS
5. workQueue        表示任务队列
6. threadFactory    用于对创建的线程进行一些配置
7. handler          表示任务拒绝策略

#### 详解
1. 一般情况下，有新任务到来的时候，如果当前线程个数小于corePoolSiz，就会创建一个新线程来执行该任务，需要说明的是，即使其他线程现在也是空闲的，也会创建新线程。
2. 不过，如果线程个数大于等于corePoolSiz，那就不会立即创建新线程了，它会先尝试排队，需要强调的是，它是"尝试"排队，而不是"阻塞等待"入队，如果队列满了或其他原因不能立即入队，它就不会排队，而是检查线程个数是否达到了maximumPoolSize，如果没有，就会继续创建线程，直到线程数达到maximumPoolSize。
3. keepAliveTime的目的是为了释放多余的线程资源，它表示，当线程池中的线程个数大于corePoolSize时，额外空闲线程的存活时间，也就是说，一个非核心线程，在空闲等待新任务时，会有一个最长等待时间，即keepAliveTime，如果到了时间还是没有新任务，就会被终止。如果该值为0，表示所有线程都不会超时终止，即没有新任务线程立刻会被回收。

#### ThreadPoolExecutor其他的一些方法
```
//返回当前线程个数
public int getPoolSize()
//返回线程池曾经达到过的最大线程个数
public int getLargestPoolSize()
//返回线程池自创建以来所有已完成的任务数
public long getCompletedTaskCount()
//返回所有任务数，包括所有已完成的加上所有排队待执行的
public long getTaskCount()
```
#### 对列
ThreadPoolExecutor要求的队列类型是阻塞队列BlockingQueue，例如
* LinkedBlockingQueue：基于链表的阻塞队列，可以指定最大长度，但默认是无界的。
* ArrayBlockingQueue：基于数组的有界阻塞队列
* PriorityBlockingQueue：基于堆的无界阻塞优先级队列
* SynchronousQueue：没有实际存储空间的同步阻塞队列  
 
**对于SynchronousQueue，我们知道，它没有实际存储元素的空间，当尝试排队时，只有正好有空闲线程在等待接受任务时，才会入队成功，否则，总是会创建新线程，直到达到maximumPoolSize。**   
**如果用的是无界队列，需要强调的是，线程个数最多只能达到corePoolSize，到达corePoolSize后，新的任务总会排队，参数maximumPoolSize也就没有意义了。**

#### 任务拒绝策略
如果队列有界，且maximumPoolSize有限，则当队列排满，线程个数也达到了maximumPoolSize，这时，新任务来了，如何处理呢？此时，会触发线程池的任务拒绝策略。       
默认情况下，提交任务的方法如execute/submit/invokeAll等会抛出异常，类型为RejectedExecutionException。

不过，拒绝策略是可以自定义的，ThreadPoolExecutor实现了四种处理方式：

1. ThreadPoolExecutor.AbortPolicy：这就是默认的方式，抛出异常
2. ThreadPoolExecutor.DiscardPolicy：静默处理，忽略新任务，不抛异常，也不执行
3. ThreadPoolExecutor.DiscardOldestPolicy：将等待时间最长的任务扔掉，然后自己排队
4. ThreadPoolExecutor.CallerRunsPolicy：在任务提交者线程中执行任务，而不是交给线程池中的线程执行     

它们都是ThreadPoolExecutor的public静态内部类，都实现了RejectedExecutionHandler接口       
**拒绝策略只有在队列有界，且maximumPoolSize有限的情况下才会触发。**
1. 如果队列无界，服务不了的任务总是会排队，但这不见得是期望的，因为请求处理队列可能会消耗非常大的内存，甚至引发内存不够的异常。
2. 如果队列无界，服务不了的任务总是会排队，但这不见得是期望的，因为请求处理队列可能会消耗非常大的内存，甚至引发内存不够的异常。
3. 所以，在任务量非常大的场景中，让拒绝策略有机会执行是保证系统稳定运行很重要的方面。

#### 线程工厂
线程池还可以接受一个参数，ThreadFactory，它是一个接口，定义为：
```
public interface ThreadFactory {
    Thread newThread(Runnable r);
}
```
这个接口根据Runnable创建一个Thread，ThreadPoolExecutor的默认实现是Executors类中的静态内部类DefaultThreadFactory，主要就是创建一个线程，给线程设置一个名称，设置daemon属性为false，设置线程优先级为标准默认优先级，线程名称的格式为： pool-<线程池编号>-thread-<线程编号>。

如果需要自定义一些线程的属性，比如名称，可以实现自定义的ThreadFactory。
#### 关于核心线程的特殊配置
线程个数小于等于corePoolSize时，我们称这些线程为核心线程，默认情况下：
1. 核心线程不会预先创建，只有当有任务时才会创建
2. 核心线程不会因为空闲而被终止，keepAliveTime参数不适用于它
不过，ThreadPoolExecutor有如下方法，可以改变这个默认行为。
```
//预先创建所有的核心线程
public int prestartAllCoreThreads()
//创建一个核心线程，如果所有核心线程都已创建，返回false
public boolean prestartCoreThread()
//如果参数为true，则keepAliveTime参数也适用于核心线程
public void allowCoreThreadTimeOut(boolean value)
```

newFixedThreadPool的代码为：
```
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
```
使用固定数目的n个线程，使用无界队列LinkedBlockingQueue，线程创建后不会超时终止。和newSingleThreadExecutor一样，由于是无界队列，如果排队任务过多，可能会消耗非常大的内存。

newSingleThreadExecutor基本相当于调用：
```
public static ExecutorService newSingleThreadExecutor() {
    return new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>());
}
```
只使用一个线程，使用无界队列LinkedBlockingQueue，线程创建后不会超时终止，该线程顺序执行所有任务。该线程池适用于需要确保所有任务被顺序执行的场合。

newCachedThreadPool的代码为：
```
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
```
它的corePoolSize为0，maximumPoolSize为Integer.MAX_VALUE，keepAliveTime是60秒，队列为SynchronousQueue。

它的含义是，当新任务到来时，如果正好有空闲线程在等待任务，则其中一个空闲线程接受该任务，否则就总是创建一个新线程，创建的总线程个数不受限制，对任一空闲线程，如果60秒内没有新任务，就终止。
# 关于线程池的选择：
1. 在系统负载很高的情况下，newFixedThreadPool可以通过队列对新任务排队，保证有足够的资源处理实际的任务，而newCachedThreadPool会为每个任务创建一个线程，导致创建过多的线程竞争CPU和内存资源，使得任何实际任务都难以完成，这时，newFixedThreadPool更为适用。

2. 不过，如果系统负载不太高，单个任务的执行时间也比较短，newCachedThreadPool的效率可能更高，因为任务可以不经排队，直接交给某一个空闲线程。

3. 在系统负载可能极高的情况下，两者都不是好的选择，newFixedThreadPool的问题是队列过长，而newCachedThreadPool的问题是线程过多，这时，应根据具体情况自定义ThreadPoolExecutor，传递合适的参数。

#### 线程池的死锁
1. 替换newFixedThreadPool为newCachedThreadPool，让创建线程不再受限，这个问题就没有了。
2. 使用SynchronousQueue，它可以避免死锁，怎么做到的呢？对于普通队列，入队只是把任务放到了队列中，而对于SynchronousQueue来说，入队成功就意味着已有线程接受处理，如果入队失败，可以创建更多线程直到maximumPoolSize，如果达到了maximumPoolSize，会触发拒绝机制，不管怎么样，都不会死锁。
# 总结
ThreadPoolExecutor实现了生产者/消费者模式，工作者线程就是消费者，任务提交者就是生产者，线程池自己维护任务队列。当我们碰到类似生产者/消费者问题时，应该优先考虑直接使用线程池，而非重新发明轮子，自己管理和维护消费者线程及任务队列。
