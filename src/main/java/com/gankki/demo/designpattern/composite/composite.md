# 组合模式 Composite Pattern /kɑm'pɑzɪt/ n. 复合材料，合成物；adj. 复合的，合成的；

Compose objects into tree structures to represent part-whole hierarchies.Composite lets clients treat individual objects and compositions of objects uniformly.

将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致型。

#### 优点
1. 高层模块调用简单
2. 节点自由增加

#### 缺点
1. 与依赖倒置原则冲突，限制了使用接口的影响范围

#### 使用场景
1. 维护和展示部分-整体关系的场景
2. 从一个整体能独立出部分模块或功能的场景

#### 使用场景
1. 只要是树形结构
2. 能体现出整体和部分的关系