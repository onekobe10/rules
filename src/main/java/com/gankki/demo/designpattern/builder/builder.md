# 建造者模式 Builder Pattern

Separate the construction of a complex object from its representation so that the same
construction process can create different representations.

将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

#### 建造者模式的优点
1. 封装性
2. 建造者独立，容易扩展
3. 便于控制细节

#### 建造者模式的使用场景
1. 相同的方法，不同的顺序，产生不同的事件结果时
2. 多个部件或零件都可以装配到一个对象中去，但是产生的运行结果又不相同时
3. 产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效用时

>建造者模式关注的是零件类型和装配工艺（顺序），这是它与工厂方法模式最大的不同地方，虽然都为创建类模式，但是注重点不同。        
>建造者如何去建造一个对象？是零件的组装，组装顺序不同对象效能也不同，这是建造者模式要表达的核心意义。

**建造者模式最主要的功能是基本方法的调用顺序安排，也就是这些方法基本都实现了，通俗地说就是零件的装配，顺序不同产生的对象也不同；而工厂方法模式重点是创建，创建零件是它的主要职责，组装顺序不是它关心的**


