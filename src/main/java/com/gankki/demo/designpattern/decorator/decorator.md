# 装饰模式 Decorator Pattern

Attach additional responsibilities to an object dynamically keeping the same interface.Decorators provide a flexible alternative to subclassing for extending functionality.
在保持相同接口的条件不变的条件下，动态给一个对象添加一些额外的职责，装饰模式哟相比通过子类来扩展功能提供了更灵活的选择。

#### 装饰模式的优点
1. 装饰类和被装饰类可以独立发展，而不会相互耦合
2. **装饰模式是继承关系的一个替代方案。不管装饰了多少层。返回的对象还是Component，实现的还是is-a的关系**
3. 装饰模式可以动态地扩展一个实现类的功能
#### 装饰模式的使用场景
1. 需要扩展一个类的功能，或给一个类添加附加功能
2. 需要动态地给一个对象添加功能，这些功能可以再动态地撤销
3. 需要为一批兄弟类进行改装或者加装功能，首选装饰模式    避免出现两层以上的继承
#### 最佳实践
1. 装饰模式是对继承的有力补充，装饰模式可以代替类的继承，解决类膨胀的问题       
2. 继承是静态地给类添加新的功能，装饰模式是动态地添加功能
3. 扩展性非常好


