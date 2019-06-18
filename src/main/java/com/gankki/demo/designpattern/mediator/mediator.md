# 中介者模式 Mediator Pattern /'midɪetɚ/ 

Define an object that encapsulates how a set of objects interact.Mediator promotes loose coupling by keeping objects from referring to each other
explicitly,and it lets you vary their interaction independently.

用一个中介对象封装一系列的对象交互，中介者使各对象不需要显式地互相作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。

#### 中介者模式的优点
> 减少了类间的依赖，把原来的一对多的依赖关系变成了一对一的依赖，同事类只依赖于中介者，减少了依赖，同时降低了类间的耦合。
#### 中介者模式的缺点
> 中介者会膨胀的很大，逻辑会很复杂，原本N个对象直接的相互依赖关系转换为中介者h和同事类的依赖关系，同事类越多，中介者的逻辑就越复杂。
#### 使用场景
> MVC框架，其中C（Controller），就是一个中介者，前端控制器，它的作用就是把M（Model，业务逻辑）和V（View，视图）隔离开来，协调M和V的工作，把M的运行的结果和V代表的视图融合成一个前端可以展示的页面，减少了M和V的依赖关系，这就是中介者模式的一个体现。
#### 最佳实践
尝试使用中介者模式：      
1. N个对象之间产生了相互依赖的关系（N > 2）
2. 多个对象有依赖关系，但是依赖的行为尚不确定或者有发生改变的可能，可以使用中介者模式，降低变更引起的风险扩散
3. 产品开发。MVC框架，把中介者模式应用到产品中，可以提高产品的性能和扩展性
