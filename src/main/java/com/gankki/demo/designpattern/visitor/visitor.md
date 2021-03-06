# Visitor Patter 访问者模式

Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作

#### 优点
1. 符合单一职责原则
2. 优秀的扩展性
3. 灵活性非常高

#### 缺点
1. 具体元素对访问者公布细节
2. 具体元素变更比较困难
3. 违背了依赖倒置原则

#### 使用场景
1. 一个对象结构包含很多类对象，它们有不同的接口，而你想对这些对象实施一些依赖于其具体类的操作，也就是迭代器模式不能适用的场景
2. 需要对一个对象结构中的对象进行很多不同并且不相关的操作，而你想避免让这些操作“污染”这些对象的类
> 业务规则要求遍历多个不同的对象。迭代器模式只能访问同类或者同接口的数据。访问者模式是对迭代器模式的扩充。



