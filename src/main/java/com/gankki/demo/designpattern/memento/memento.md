# 备忘录模式 Memento Pattern

Without violating encapsulation,capture and externalize an object's internal state so that the object can be restored to this state later.

在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。

备忘录模式就是一个对象的备份模式，提供了一种程序数据的备份方法。

#### 使用场景
1. 需要保存和恢复数据的相关状态场景
2. 提供一个可回滚的操作
3. 需要监控的副本场景中。
4. 数据库连接的事务管理就是用的备忘录模式

#### 注意事项
1. 备忘录的生命期。要主动管理它的生命周期，建立就要使用，不使用就要立刻删除其引用，等待 GC 对它的回收处理
2. 备忘录的性能


