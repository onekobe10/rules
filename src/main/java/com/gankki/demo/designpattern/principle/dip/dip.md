
## 依赖倒置原则	Dependence Inversion Principle DIP

#### 1. 含义
1. 高层模块不应该依赖于底层模块，两者都应该依赖于抽象
2. 抽象不应该依赖于细节
3. 细节应该依赖于抽象
#### 2. 在java的含义
1. 模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或者抽象类产生的
2. 接口或者抽象类不依赖于实现类
3. 实现类依赖于接口或者抽象类

依赖正置：面向过程的开发，上层调用下层，上层依赖于下层，当下层剧烈变动时上层也要跟着变动，这就会导致模块的复用性降低而且大大提高了开发的成本。     
面向对象的开发（Object-Oriented Design 面向对象的开发，OOD的精髓就是面向接口的编程）很好的解决了这个问题，一般情况下抽象的变化概率很小，让用户程序依赖于抽象，实现的细节也依赖于抽象。即使实现细节不断变动，只要抽象不变，客户程序就不需要变化。这大大降低了客户程序与实现细节的耦合度。       
一般的依赖是上层调用下层，上层依赖下层。面向接口的开发是，下层的实现依赖于上层的抽象（接口）。
#### 最佳实践
1. 每个类尽量都有接口或者抽象类，或者两者都具备。这是依赖倒置的基本要求，接口和抽象类都是抽象的，有了抽象才可能依赖倒置
2. 变量的表面类型尽量是接口或者抽象类
3. 任何类都不应该从具体类派生 任何类尽量不要从继承其他类产生
4. 尽量不要重写基类的方法
5. 结合里氏替换原则使用
## 总结
**1. 面向接口编程，而不是面向对象编程**        
**2. 接口负责定义pubic方法和静态常量，并且声明与其他对象的依赖关系，抽象类负责公共构造部分的实现，实现类准确的实现业务逻辑，同时在适当的时候对父类进行细化**


            
