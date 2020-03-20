# Design Pattern & Design Principle

#### Design Principle
1. Open Closed Principle OCP 开闭原则
2. Single Responsibility Principle SRP 单一职责原则
3. Liskov Substitution Principle LSP 里氏代换原则
4. Law of Demeter LOD 迪米特法则
5. Interface Segregation Principle ISP 接口隔离原则
6. Dependence Inversion Principle DIP 依赖倒置原则
#### Design Pattern
1. 单例模式 Singleton Pattern
2. 装饰模式 Decorator Pattern
3. 适配器模式 Adapter Pattern
4. 迭代器模式 Iterator Pattern
5. 责任链模式 Chain of Responsibility Pattern
6. 工厂方法模式 Factory Method Pattern
7. 抽象工厂模式 Abstract Factory Pattern
8. 模板方法模式 Template Method Pattern
9. 建造者模式 Builder Pattern
10. 代理模式 Proxy Pattern
11. 原型模式 Prototype Pattern
12. 中介者模式 Mediator Pattern
13. 命令模式 Command Pattern
14. 策略模式 Strategy Pattern
15. 组合模式 Composite Pattern
16. 观察者模式 Observer Pattern
17. 门面模式 Facade Pattern
18. 备忘录模式 Memento Pattern
19. 访问者模式 visitor Pattern
20. 状态模式 State Pattern
21. 解释器模式 Interpreter Pattern
22. 享元模式 Flyweight Pattern
23. 桥梁模式 Bridge Pattern
24. 模型视图控制器模型 MVC Model-View-Controller

#### Gankki's Note
1. 原型模式：在一些重复创建对象的场景下，我们就可以使用原型模式来提高对象的创建性能。
```
1. clone 方法比使用 new 实例化对象效率更高。
2. Object 类的 clone 方法是一个本地方法，它直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显
3.  Spring 中，@Service 默认都是单例的。用了私有全局变量，若不想影响下次注入或每次上下文获取 bean，就需要用到原型模式，我们可以通过以下注解来实现，@Scope(“prototype”)。
for(int i=0; i<list.size(); i++){
  Student stu = new Student(); 
  ...
}
Student stu = new Student(); 
for(int i=0; i<list.size(); i++){
 Student stu1 = (Student)stu.clone();
  ...
}
2.

```
2. 享元模式：运用共享技术有效地最大限度地复用细粒度对象的一种模式。
```
1. Java 的 String 字符串，在一些字符串常量中，会共享常量池中字符串对象，从而减少重复创建相同值对象，占用内存空间。
2. 线程池就是享元模式的一种实现

一个对象通过new创建的过程为：
1、在内存中开辟一块空间；
2、在开辟的内存空间中创建对象；
3、调用对象的构造函数进行初始化对象。

而一个对象通过clone创建的过程为：
1、根据原对象内存大小开辟一块内存空间；
2、复制已有对象，克隆对象中所有属性值。

相对new来说，clone少了调用构造函数。如果构造函数中存在大量属性初始化或大对象，则使用clone的复制对象的方式性能会好一些。

总结：在不得已需要重复创建大量同一对象时，我们可以使用原型模式，通过 clone 方法复制对象，这种方式比用 new 和序列化创建对象的效率要高；
在创建对象时，如果我们可以共用对象的内部数据，那么通过享元模式共享相同的内部数据的对象，就可以减少对象的创建，实现系统调优。

享元模式是单例模式的超集。A 是 B 的子集，则 B 是 A 的超集。
```
3. 工厂方法模式中的PSEC
6. 命令模式的优点
7. 观察模式中广播链和责任链模式的区别
8. 建造者模式 责任链模式


