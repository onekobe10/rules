# Abstract Factory Pattern 抽象工厂模式

Provide an interface for creating families of related or dependent objects without specifying
their concrete classes.

为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它们的具体类。

抽象工厂模式是工厂方法模式的升级版本，在多个业务品种、业务分类时，通过抽象工厂模式产生需要的对象时是一种非常好的解决方法。

#### 抽象工厂模式的优点
1. 封装性
2. 产品族内的约束为非公开状态，具体的产品族而的约束是在工厂内实现的。
#### 抽象工厂模式的缺点
最大的缺点是产品族的扩展非常困难
#### 抽象工厂模式的使用场景
一个对象族（或是一组没有任何关系的对象），都有相同的约束，则可以使用抽象工厂模式。

#### Gankki's Note
抽象工厂模式是将一组有相同约束的对象的实例化整合到一个工厂类中，由这个工厂类去负责这组对象的创建。
