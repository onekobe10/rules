# ThreadLocal  线程本地变量

线程本地变量是说，每个线程都有同一个变量的独有拷贝。

各个线程之间即使共享一个ThreadLocal变量，变量中值也是自己独有，各个线程不共享的。

#### 使用场景
1. DateFormat/SimpleDateFormat      
ThreadLocal是实现线程安全的一种方案，比如对于DateFormat/SimpleDateFormat，它们是非线程安全的，实现安全的一种方式是使用锁，另一种方式是每次都创建一个新的对象，更好的方式就是使用ThreadLocal，每个线程使用自己的DateFormat，就不存在安全问题了，在线程的整个使用过程中，只需要创建一次，又避免了频繁创建的开销        
**需要说明的是，ThreadLocal对象一般都定义为static，以便于引用。**
2. ThreadLocalRandom        
即使对象是线程安全的，使用ThreadLocal也可以减少竞争，比如，Random类，Random是线程安全的，但如果并发访问竞争激烈的话，性能会下降，所以Java并发包提供了类ThreadLocalRandom，它是Random的子类，利用了ThreadLocal，它没有public的构造方法，通过静态方法current获取对象，比如：
```
public static void main(String[] args) {
    ThreadLocalRandom rnd = ThreadLocalRandom.current();
    System.out.println(rnd.nextInt());
}
```
current方法的实现为：
```
public static ThreadLocalRandom current() {
    return localRandom.get();
}
```
localRandom就是一个ThreadLocal变量：
```
private static final ThreadLocal<ThreadLocalRandom> localRandom =
    new ThreadLocal<ThreadLocalRandom>() {
        protected ThreadLocalRandom initialValue() {
            return new ThreadLocalRandom();
        }
};
```
3. 上下文信息        
ThreadLocal的典型用途是提供上下文信息，比如在一个Web服务器中，一个线程执行用户的请求，在执行过程中，很多代码都会访问一些共同的信息，比如请求信息、用户身份信息、数据库连接、当前事务等，它们是线程执行过程中的全局信息，如果作为参数在不同代码间传递，代码会很啰嗦，这时，使用ThreadLocal就很方便，所以它被用于各种框架如Spring中

#### 实现原理

ThreadLocal是怎么实现的呢？为什么对同一个对象的get/set，每个线程都能有自己独立的值呢？我们直接来看代码。

set方法的代码为：
```
public void set(T value) {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null)
        map.set(this, value);
    else
        createMap(t, value);
}
```
它调用了getMap，getMap的代码为：
```
ThreadLocalMap getMap(Thread t) {
    return t.threadLocals;
}
```
返回线程的实例变量threadLocals，它的初始值为null，在null时，set调用createMap初始化，代码为：
```
void createMap(Thread t, T firstValue) {
    t.threadLocals = new ThreadLocalMap(this, firstValue);
}
```
每个线程都有一个Map，类型为ThreadLocalMap，调用set实际上是在线程自己的Map里设置了一个条目，键为当前的ThreadLocal对象，值为value。ThreadLocalMap是一个内部类，它是专门用于ThreadLocal的，与一般的Map不同，它的键类型为WeakReference<ThreadLocal>，它与Java的垃圾回收机制有关，使用它，便于回收内存
```
public class Thread implements Runnable {
    /* ThreadLocal values pertaining to this thread. This map is maintained
     * by the ThreadLocal class. */
    ThreadLocal.ThreadLocalMap threadLocals = null;

    /*
     * InheritableThreadLocal values pertaining to this thread. This map is
     * maintained by the InheritableThreadLocal class.
     */
    ThreadLocal.ThreadLocalMap inheritableThreadLocals = null;
}
```
```
public class ThreadLocal<T> {
    static class ThreadLocalMap {
        static class Entry extends WeakReference<ThreadLocal<?>> {
                /** The value associated with this ThreadLocal. */
                Object value;
    
                Entry(ThreadLocal<?> k, Object v) {
                    super(k);
                    value = v;
                }
            }
    }
}
```
```
/**
 * Construct a new map initially containing (firstKey, firstValue).
 * ThreadLocalMaps are constructed lazily, so we only create
 * one when we have at least one entry to put in it.
 */
ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
    table = new Entry[INITIAL_CAPACITY];
    int i = firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1);
    table[i] = new Entry(firstKey, firstValue);
    size = 1;
    setThreshold(INITIAL_CAPACITY);
}
```
get方法的代码为：
```
public T get() {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null) {
        ThreadLocalMap.Entry e = map.getEntry(this);
        if (e != null)
            return (T)e.value;
    }
    return setInitialValue();
}
```
```
private T setInitialValue() {
    T value = initialValue();
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null)
        map.set(this, value);
    else
        createMap(t, value);
    return value;
}
```
initialValue()就是之前提到的提供初始值的方法，默认实现就是返回null。
```
public void remove() {
   ThreadLocalMap m = getMap(Thread.currentThread());
   if (m != null)
       m.remove(this);
}
```
每个线程都有一个Map，对于每个ThreadLocal对象，调用其get/set实际上就是以ThreadLocal对象为键读写当前线程的Map，这样，就实现了每个线程都有自己的独立拷贝的效果。

#### 线程池与ThreadLocal
因为线程池中的线程在执行完一个任务，执行下一个任务时，其中的ThreadLocal对象并不会被清空，修改后的值带到了下一个异步任务。那怎么办呢？有几种思路：

1. 第一次使用ThreadLocal对象时，总是先调用set设置初始值，或者如果ThreaLocal重写了initialValue方法，先调用remove
2. 使用完ThreadLocal对象后，总是调用其remove方法
3. 使用自定义的线程池

# 总结
1. ThreadLocal使得每个线程对同一个变量有自己的独立拷贝，是实现线程安全、减少竞争的一种方案。
2. ThreadLocal经常用于存储上下文信息，避免在不同代码间来回传递，简化代码。
3. 每个线程都有一个Map，调用ThreadLocal对象的get/set实际就是以ThreadLocal对象为键读写当前线程的该Map。
4. 在线程池中使用ThreadLocal，需要注意，确保初始值是符合期望的。
















