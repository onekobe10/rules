### CompletionService

#### 1. CompletionStage
1. CompletionStage 接口可以清晰地描述任务之间的时序关系：串行关系、AND 聚合关系、OR 聚合关系以及异常处理。

#### 2. 线程池必备
1. 默认情况下 CompletableFuture 会使用公共的 ForkJoinPool 线程池，这个线程池默认创建的线程数是 CPU 的核数（也可以通过 JVM option:-Djava.util.concurrent.ForkJoinPool.common.parallelism 来设置 ForkJoinPool 线程池的线程数）。如果所有 CompletableFuture 共享一个线程池，那么一旦有任务执行一些很慢的 I/O 操作，就会导致线程池中所有线程都阻塞在 I/O 操作上，从而造成线程饥饿，进而影响整个系统的性能。所以，强烈建议你要根据不同的业务类型创建不同的线程池，以避免互相干扰。
2. 数据库属于io 操作，应该放在单独线程池，避免线程饥饿
#### 3. CompletableFuture get/join
1. get 会抛出受检异常：InterruptedException, ExecutionException
2. join 如果产生异常，会抛出运行时异常：CompletionException 

#### 3. CompletionService：批量执行异步任务
1. 