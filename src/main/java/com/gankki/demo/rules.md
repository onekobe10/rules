
# Gankki's Note

##### 1. Java 重写必须满足的条件 override
1. 重写方法不能缩小访问权限
2. 参数列表必须与被重写方法相同（包括显示形式）
3. 返回类型必须与被重写方法的相同或是其子类
4. 重写方法不能抛出新的异常，或者超过了父类范围的异常，但是可以抛出更少、更有限的异常，或者不抛出异常

##### 2. Java 重载必须满足的条件 overload
1. 方法的重载跟返回值类型、修饰符无关以及是否抛出异常无关,Java的重载是发生在本类中的,重载的条件是在本类中有多个方法名相同的方法
2. 重载的条件：方法名相同,方法参数的个数和类型不同,通过个数和类型的不同来区分不同的重载方法        
final关键字修饰的方法可以重载，但是不能重写。
#### 3. 反射 reflect
1. setAccessible(boolean flag)  如果对类中的构造方法、属性、方法等访问权限不够，如为私有的，则可以在获取到权限不够的对象之后，设置accessible为true即可正常操作这个本来权限不够的对象。
#### 4. 类初始化和实例化
1. 类的初始化是指为类中各个类成员(被static修饰的成员变量)赋初始值的过程，是类生命周期中的一个阶段。
2. 类的实例化是指创建一个类的实例(对象)的过程；
#### 5.接口
JDK1.8中接口中可以增加静态方法和defult修饰的默认方法，扩展了接口的使用场景，虽然是default修饰的默认方法，但是可以可以可见性上和public一样，没有其他包和子类不可见的限制。
#### 6.父子类调用顺序
父类的静态代码块>子类的静态代码块>父类的普通代码块>父类的构造方法>子类的普通代码块>子类的构造方法
**静态代码块属于类的一部分，随着类的加载被执行。普通代码块是实例对象的一部分，会在实例化对象时在构造方法之前被调用**