# 适配器模式 Adapter Pattern

Convert the interface of a class into another interface clients expect.Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
将类的接口转换成客户端期待的另一个接口，从而使原本因接口不匹配而无法一起工作的两个类能够在一起工作。

适配器模式也叫变压器模式，又叫包装模式（Wrapper）,但是包装模式不止一个，装饰模式也是包装模式。
#### 适配器模式的优点
1. 适配器模式可以让两个没有任何关系的类在一起运行，只要适配器这个角色能搞定它们之间的差异就成
2. 增加了类的透明度 将其他类改成了能适配目标角色的功能，而这些改动对高层次模块是透明的
3. 提高了类的复用度
4. 灵活性非常好

**适配器模式不是为详情设计阶段存在的，它不是为了解决还处在开发阶段的问题，而是解决已经上线项目的问题。如果有动机修改一个已经投产的接口，适配器模式可能是最适合的模式。**

#### 适配器模式的种类
1. 类适配器
2. 对象适配器 

类适配器是类间继承，对象适配器是对象的合成关系，也可以说是类间的关联关系。

**技术是为业务服务的，谨记。**