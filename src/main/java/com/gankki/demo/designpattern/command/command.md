# 命令模式 Command Pattern

Encapsulate a request as an object,thereby letting you parameterize clients with different requests,queue or log requests,and support undoable operations.

将一个请求封装成一个对象，从而让你使用不同的请求把客户端参数化，对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能。

如果一个请求需要流程处理，且流程数量可控，我们可以将一个请求的处理流程作为一个命令对象，一个请求对应一种命令对象，然后我们只需要调用命令对象中封装的方法即可。

核心：将每一个请求的处理流程封装成一个命令对象，每一个请求都作为一个命令整体来执行。

#### 优点
1. 类间解耦
2. 可扩展性
3. 命令模式结合其他模式更优秀
> 命令模式结合责任链模式，实现命令簇解析任务，结合模板方法模式，则可以减少Command子类的膨胀问题。



