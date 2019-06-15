# 原型模式 Prototype Pattern

Specify the kinds of objects to create using a prototypical instance,and create new objects by
copying this prototype.

用原型实例指定创建对象的类型，并且通过拷贝原型实例来创建新的对象

#### 原型模式的优点
1. 性能优良，内存拷贝
> 原型模式是内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量的对象时，原型模式可以更好地体现其优点
2. 逃避构造函数的约束
> 既是优点也是缺点，直接在内存中拷贝，构造函数不会执行。
#### 使用场景
1. 资源优化场景
2. 性能和安全要求的场景
3. 一个对象多个修改者的场景
#### 注意
1. 深拷贝和浅拷贝
2. 深拷贝时成员变量不能被final修饰，浅拷贝成员变量可以被final修饰。（说明了final变量可以被拷贝，不可以被修改的特性）
