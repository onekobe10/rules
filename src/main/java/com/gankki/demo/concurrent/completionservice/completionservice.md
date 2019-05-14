# CompletionService

在异步任务程序中，一种常见的场景是，主线程提交多个异步任务，然后希望有任务完成就处理结果，并且按任务完成顺序逐个处理，对于这种场景，Java并发包提供了一个方便的方法，使用CompletionService，这是一个接口，它的实现类是ExecutorCompletionService

```
public interface CompletionService<V> {
    Future<V> submit(Callable<V> task);
    Future<V> submit(Runnable task, V result);
    Future<V> take() throws InterruptedException;
    Future<V> poll();
    Future<V> poll(long timeout, TimeUnit unit) throws InterruptedException;
}
```
其submit方法与ExecutorService是一样的，多了take和poll方法，它们都是获取下一个完成任务的结果，take()会阻塞等待，poll()会立即返回，如果没有已完成的任务，返回null，带时间参数的poll方法会最多等待限定的时间。
#### 实现细节
CompletionService主要实现类是ExecutorCompletionService，其有一个阻塞队列为
private final BlockingQueue<Future<V>> completionQueue;
其submit方法：  
```
public Future<V> submit(Callable<V> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
        return f;
    }
 ```
 FutureTask对象，任务完成后，不管是正常完成、异常结束、还是被取消，都会调用finishCompletion方法，而该方法会调用一个done方法，该方法代码为：
```
protected void done() { }
```
它的实现为空，但它是一个protected方法，子类可以重写该方法。

在ExecutorCompletionService中，提交的任务类型不是一般的FutureTask，而是一个子类QueueingFuture
```
private class QueueingFuture extends FutureTask<Void> {
    QueueingFuture(RunnableFuture<V> task) {
        super(task, null);
        this.task = task;
    }
    protected void done() { completionQueue.add(task); }
    private final Future<V> task;
}
```
也就是任务执行完毕后，会将执行结果添加到completionQueue队列中去。
# 总结
CompletionService通过一个额外的结果队列，方便了对于多个异步任务结果的处理。


