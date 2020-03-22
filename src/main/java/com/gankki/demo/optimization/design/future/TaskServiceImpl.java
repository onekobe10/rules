package com.gankki.demo.optimization.design.future;


public class TaskServiceImpl<T, P> implements TaskService<T, P> {

    /**
     * 提交任务实现方法，不需要返回执行结果
     */
    @Override
    public Future<?> submit(Runnable runnable) {
        final FutureTask<Void> future = new FutureTask<>();
        new Thread(() -> runnable.run(), Thread.currentThread().getName()).start();
        return future;
    }

    /**
     * 提交任务实现方法，需要返回执行结果
     */
    @Override
    public Future<?> submit(Task<T, P> task, P param) {
        final FutureTask<T> future = new FutureTask<>();
        new Thread(() -> {
            T result = task.doTask(param);
            future.finish(result);
        }, Thread.currentThread().getName()).start();
        return future;
    }
}
