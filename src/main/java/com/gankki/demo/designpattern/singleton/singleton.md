# 单例模式 Singleton Pattern

Ensure a class has only one instance, and provide a global point of access to it.
确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例

单例类的条件：    
1. 一个私有的构造方法  避免被其他类new出来一个对象，私有的构造方法只可以在本类中使用
2. 一个私有的此单例类的静态常量的成员变量 
3. 一个公开的静态获取此单例引用的方法

单例类的分类：     
1. 饱汉式单例 推荐
2. 饿汉式单例

#### 最佳实践
在Spring中，每个Bean默认为单例的（Singleton），这样做的优点是Spring容器可以管理这些Bean的生命周期，决定在什么时候创建出来，什么时候销毁，销毁的时候如何处理，等等。如果采用非单例模式（Prototype），
则Bean初始化之后的生命周期管理就交给J2EE容器，如Tomcat等来管理了，Spring容器将不再跟踪管理Bean的生命周期。     
