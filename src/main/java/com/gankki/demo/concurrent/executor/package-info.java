package com.gankki.demo.concurrent.executor;

/**
 * 	Java并发包提供了一套框架，大大简化了执行异步任务所需的开发
 *
 * 	线程Thread既表示要执行的任务，又表示执行的机制，而这套框架引入了一个"执行服务"的概念，
 * 	它将"任务的提交"和"任务的执行"相分离，"执行服务"封装了任务执行的细节，
 * 	对于任务提交者而言，它可以关注于任务本身，如提交任务、获取结果、取消任务，
 * 	而不需要关注任务执行的细节，如线程创建、任务调度、线程关闭等。
 *
 *	Executor表示最简单的执行服务，其定义为：
 *		public interface Executor {
 *    	 	void execute(Runnable command);
 * 		}
 *	就是可以执行一个Runnable，没有返回结果。接口没有限定任务如何执行，
 *	可能是创建一个新线程，可能是复用线程池中的某个线程，也可能是在调用者线程中执行。
 *
 *	ExecutorService扩展了Executor，定义了更多服务，基本方法有：
 *	public interface ExecutorService extends Executor {
 *     <T> Future<T> submit(Callable<T> task);
 *     <T> Future<T> submit(Runnable task, T result);
 *     Future<?> submit(Runnable task);
 *     //... 其他方法
 * }
 *
 * 	***这三个submit都表示提交一个任务，返回值类型都是Future，返回后，只是表示任务已提交，不代表已执行，
 * 	通过Future可以查询异步任务的状态、获取最终结果、取消任务等。
 * 	我们知道，对于Callable，任务最终有个返回值，而对于Runnable是没有返回值的，
 * 	第二个提交Runnable的方法可以同时提供一个结果，在异步任务结束时返回，
 * 	而对于第三个方法，异步任务的最终返回值为null。***
 *
 *  public interface Future<V> {
 *     boolean cancel(boolean mayInterruptIfRunning);
 *     boolean isCancelled();
 *     boolean isDone();
 *     V get() throws InterruptedException, ExecutionException;
 *     V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
 *  }
 *	get用于返回异步任务最终的结果，如果任务还未执行完成，会阻塞等待，
 *	另一个get方法可以限定阻塞等待的时间，如果超时任务还未结束，会抛出TimeoutException。
 *
 *	cancel用于取消异步任务，如果任务已完成、或已经取消、或由于某种原因不能取消，cancel返回false，否则返回true。
 *	如果任务还未开始，则不再运行。但如果任务已经在运行，则不一定能取消，
 *	参数mayInterruptIfRunning表示，如果任务正在执行，是否调用interrupt方法中断线程，
 *	如果为false就不会，如果为true，就会尝试中断线程，但我们知道，中断不一定能取消线程。
 *
 *	isDone和isCancelled用于查询任务状态。
 *		isCancelled表示任务是否被取消，只要cancel方法返回了true，随后的isCancelled方法都会返回true，即使执行任务的线程还未真正结束。
 *		isDone表示任务是否结束，不管什么原因都算，可能是任务正常结束、可能是任务抛出了异常、也可能是任务被取消。
 *
 *  get方法，任务最终大概有三个结果：
 * 		1.正常完成，get方法会返回其执行结果，如果任务是Runnable且没有提供结果，返回null
 * 		2.任务执行抛出了异常，get方法会将异常包装为ExecutionException重新抛出，通过异常的getCause方法可以获取原异常
 * 		3.任务被取消了，get方法会抛出异常CancellationException
 * 		如果调用get方法的线程被中断了，get方法会抛出InterruptedException。
 *
 *	Future代表了异步计算的结果，是一个重要的概念，是实现"任务的提交"与"任务的执行"相分离的关键，
 *	是其中的"纽带"，任务提交者和任务执行服务通过它隔离各自的关注点，同时进行协作。
 *
 *
 *
 *
 */