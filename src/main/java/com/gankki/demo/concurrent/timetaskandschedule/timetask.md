# TimerTask Timer ScheduledExecutorService  定时任务
在Java中，有两种方式实现定时任务：
1. 使用java.util包中的Timer和TimerTask
2. 使用Java并发包中的ScheduledExecutorService
#### Timer基本原理
Timer内部主要由两部分组成，任务队列和Timer线程。任务队列是一个基于堆实现的优先级队列，按照下次执行的时间排优先级。Timer线程负责执行所有的定时任务，需要强调的是，一个Timer对象只有一个Timer线程。   
所以 TimerFixedDelay中例子才会阻塞等待。

Timer线程主体是一个循环，从队列中拿任务，如果队列中有任务且计划执行时间小于等于当前时间，就执行它，如果队列中没有任务或第一个任务延时还没到，就睡眠。如果睡眠过程中队列上添加了新任务且新任务是第一个任务，Timer线程会被唤醒，重新进行检查。

在执行任务之前，Timer线程判断任务是否为周期任务，如果是，就设置下次执行的时间并添加到优先级队列中，对于固定延时的任务，下次执行时间为当前时间加上period，对于固定频率的任务，下次执行时间为上次计划执行时间加上period。

需要强调是，下次任务的计划是在执行当前任务之前就做出了的，对于固定延时的任务，延时相对的是任务执行前的当前时间，而不是任务执行后，这与ScheduledExecutorService的固定延时计算方法是不同的，后者的计算方法更合乎一般的期望。

另一方面，对于固定频率的任务，它总是基于最先的计划计划的，所以，很有可能会出现TimerFixedRate例子中一下子执行很多次任务的情况。

**一个Timer对象只有一个Timer线程，这意味着，定时任务不能耗时太长，更不能是无限循环，否则容易导致死锁**

**Timer线程，还需要强调非常重要的一点，在执行任何一个任务的run方法时，一旦run抛出异常，Timer线程就会退出，从而所有定时任务都会被取消。如果希望各个定时任务不互相干扰，一定要在run方法内捕获所有异常。**

# Timer总结
Timer/TimerTask的基本使用是比较简单的，但我们需要注意：
1. 背后只有一个线程在运行
2. 固定频率的任务被延迟后，可能会立即执行多次，将次数补够
3. 固定延时任务的延时相对的是任务执行前的时间
4. 不要在定时任务中使用无限循环
5. 一个定时任务的未处理异常会导致所有定时任务被取消

#### ScheduledExecutorService
由于Timer/TimerTask的一些问题，Java并发包引入了ScheduledExecutorService
```
public interface ScheduledExecutorService extends ExecutorService {
    //单次执行，在指定延时delay后运行command
    public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit);
    //单次执行，在指定延时delay后运行callable
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit);
    //固定频率重复执行
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
    //固定延时重复执行
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
```
它们的返回类型都是ScheduledFuture，它是一个接口，扩展了Future和Delayed，没有定义额外方法。这些方法的大部分语义与Timer中的基本是类似的。对于固定频率的任务，第一次执行时间为initialDelay后，第二次为initialDelay+period，第三次initialDelay+2*period，依次类推。不过，对于固定延时的任务，它是从任务执行后开始算的，第一次为initialDelay后，第二次为第一次任务执行结束后再加上delay。与Timer不同，它不支持以绝对时间作为首次运行的时间。

ScheduledExecutorService的主要实现类是ScheduledThreadPoolExecutor，它是线程池ThreadPoolExecutor的子类，是基于线程池实现的，它的主要构造方法是：
```
public class ScheduledThreadPoolExecutor
        extends ThreadPoolExecutor
        implements ScheduledExecutorService{
        // 主要的构造方法
        public ScheduledThreadPoolExecutor(int corePoolSize) {
            super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
              new DelayedWorkQueue());
        }
}
```
它的任务队列是一个无界的优先级队列，所以最大线程数对它没有作用，即使corePoolSize设为0，它也会至少运行一个线程。

工厂类Executors也提供了一些方便的方法，以方便创建ScheduledThreadPoolExecutor，如下所示：
```
//单线程的定时任务执行服务
public static ScheduledExecutorService newSingleThreadScheduledExecutor()
public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory)
//多线程的定时任务执行服务
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory)
```
**由于可以有多个线程执行定时任务，一般任务就不会被某个长时间运行的任务所延迟了**

**与Timer不同，单个定时任务的异常不会再导致整个定时任务被取消了，即使背后只有一个线程执行任务**

需要强调的是，与Timer不同，没有异常被抛出来，TaskB的异常没有在任何地方体现。所以，与Timer中的任务类似，应该捕获所有异常。

# ScheduledThreadPoolExecutor总结
ScheduledThreadPoolExecutor的实现思路与Timer基本是类似的，都有一个基于堆的优先级队列，保存待执行的定时任务，它的主要不同是：

1. 它的背后是线程池，可以有多个线程执行任务
2. 它在任务执行后再设置下次执行的时间，对于固定延时的任务更为合理
3. 任务执行线程会捕获任务执行过程中的所有异常，一个定时任务的异常不会影响其他定时任务，但发生异常的任务也不再被重新调度，即使它是一个重复任务

# 总结
Java中定时任务的两种实现方式，Timer和ScheduledExecutorService，需要特别注意Timer的一些陷阱，实践中建议使用ScheduledExecutorService。

它们的共同局限是，不太胜任复杂的定时任务调度，比如，每周一和周三晚上18:00到22:00，每半小时执行一次。对于类似这种需求，可以利用我们之前在32节和33节介绍的日期和时间处理方法，或者利用更为强大的第三方类库，比如Quartz





