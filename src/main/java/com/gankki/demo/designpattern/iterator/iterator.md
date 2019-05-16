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
