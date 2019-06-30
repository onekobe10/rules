# 解释器模式 Interpreter

Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

给定一门语言，定义它的文法的表示方式，并定义一个解释器，该解释器使用该表示来解释语言中的句子

#### 优点
1. 解释器是一个简单语法分析工具，它最显著的特点就是扩展性，修改语法规则只需要相应地非终结符表达式就可以了，若扩展语法，则只需要增加非终结符类就可以了。


#### 缺点
1. 解释器模式会引起类膨胀
2. 解释器模式采用递归调用方法
3. 效率问题

#### 使用场景
1. 重复发生的问题可以使用解释器模式
2. 一个简单语法需要解释的场景