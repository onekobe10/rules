# Iterator Pattern
Provide a way to access the elements of an aggregate object sequentially without exposing its
underlying representation.  
它提供了一种访问一个容器对象中的各个元素的方法，并且不暴露该容器对象的内部细节。

迭代器模式目前已经是一个没落的模式，基本不需要自己手动实现一个迭代器。 

迭代器的应用已经非常广泛了，甚至成为了一个最基础的工具，java的容器类基本都实现了Iterable接口，不需要我们自己手动去实现了。

```
public interface Collection<E> extends Iterable<E> {

}
```

#### Gankki's Note
1. 迭代器模式中通过返回了一个迭代器对象（Iterator，一般需要自己在容器中实现Iterator的方法），避免了暴露容器对象中内部细节，迪米特法则的法则，最少知道原则的应用。
2. 迭代器中一般包含一个判断当前节点是否存在的方法，一个获取当前节点的方法，一个删除当前节点的方法。
3. 迭代器的删除方法，应该完成两个逻辑：一是删除当前元素，二是当前游标指向下一个元素。
```
public interface Iterator<E> {
    
    boolean hasNext();
    
    E next();
    
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }
    
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}
```
