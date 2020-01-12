# Efficient Programming

@author liuhao
@date 2020/1/12

世界上只有两种代码：高效代码和低效代码；

### 1.常量&变量
##### 1.1 当成员变量值无需改变时，尽量定义为静态常量
1. 在类的每个对象实例中，每个成员变量都有一份副本，而成员静态常量只有一份实例。
```
private final long timeout = 5L;

private static final long TIMEOUT = 5L;
```
##### 1.2 尽量使用基本数据类型，避免自动装箱和拆箱
1. 装箱和拆箱都是需要CPU和内存资源的，所以应尽量避免使用自动装箱和拆箱。
##### 1.3 如果变量的初值会被覆盖，就没有必要给变量赋初值
```
List<UserDO> userList = new ArrayList<>();
if (isAll) {
    userList = userDAO.queryAll();
} else {
    userList = userDAO.queryActive();
}

List<UserDO> userList;
if (isAll) {
    userList = userDAO.queryAll();
} else {
    userList = userDAO.queryActive();
}
```
##### 1.4 尽量使用函数内的基本类型临时变量
1. 在函数内，基本类型的参数和临时变量都保存在栈（Stack）中，访问速度较快；对象类型的参数和临时变量的引用都保存在栈（Stack）中，内容都保存在堆（Heap）中，访问速度较慢。在类中，任何类型的成员变量都保存在堆（Heap）中，访问速度较慢。
```
public final class Accumulator {
    private double result = 0.0D;
    public void addAll(@NonNull double[] values) {
        for(double value : values) {
            result += value;
        }
    }
    ...
}

public final class Accumulator {
    private double result = 0.0D;
    public void addAll(@NonNull double[] values) {
        for(double value : values) {
            result += value;
        }
    }
    ...
}
```
##### 1.5尽量不要在循环体外定义变量
1. 在老版JDK中，建议“尽量不要在循环体内定义变量”，但是在新版的JDK中已经做了优化。通过对编译后的字节码分析，变量定义在循环体外和循环体内没有本质的区别，运行效率基本上是一样的。
2. 反而，根据“ 局部变量作用域最小化 ”原则，变量定义在循环体内更科学更便于维护，避免了延长大对象生命周期导致延缓回收问题 。
```
UserVO userVO;
List<UserDO> userDOList = ...;
List<UserVO> userVOList = new ArrayList<>(userDOList.size());
for (UserDO userDO : userDOList) {
    userVO = new UserVO();
    userVO.setId(userDO.getId());
    ...
    userVOList.add(userVO);
}

List<UserDO> userDOList = ...;
List<UserVO> userVOList = new ArrayList<>(userDOList.size());
for (UserDO userDO : userDOList) {
    UserVO userVO = new UserVO();
    userVO.setId(userDO.getId());
    ...
    userVOList.add(userVO);
}
```
#### 1.6 不可变的静态常量，尽量使用非线程安全类
1. 不可变的静态常量，虽然需要支持多线程访问，也可以使用非线程安全类。
```
public static final Map<String, Class> CLASS_MAP;
static {
    Map<String, Class> classMap = new ConcurrentHashMap<>(16);
    classMap.put("VARCHAR", java.lang.String.class);
    ...
    CLASS_MAP = Collections.unmodifiableMap(classMap);
}

public static final Map<String, Class> CLASS_MAP;
static {
    Map<String, Class> classMap = new HashMap<>(16);
    classMap.put("VARCHAR", java.lang.String.class);
    ...
    CLASS_MAP = Collections.unmodifiableMap(classMap);
}
```
##### 1.7 不可变的成员变量，尽量使用非线程安全类
1. 不可变的成员变量，虽然需要支持多线程访问，也可以使用非线程安全类。
```
@Service
public class StrategyFactory implements InitializingBean {
    @Autowired
    private List<Strategy> strategyList;
    private Map<String, Strategy> strategyMap;
    @Override
    public void afterPropertiesSet() {
        if (CollectionUtils.isNotEmpty(strategyList)) {
            int size = (int) Math.ceil(strategyList.size() * 4.0 / 3);
            Map<String, Strategy> map = new ConcurrentHashMap<>(size);
            for (Strategy strategy : strategyList) {
                map.put(strategy.getType(), strategy);
            }
            strategyMap = Collections.unmodifiableMap(map);
        }
    }
    ...
}

@Service
public class StrategyFactory implements InitializingBean {
    @Autowired
    private List<Strategy> strategyList;
    private Map<String, Strategy> strategyMap;
    @Override
    public void afterPropertiesSet() {
        if (CollectionUtils.isNotEmpty(strategyList)) {
            int size = (int) Math.ceil(strategyList.size() * 4.0 / 3);
            Map<String, Strategy> map = new HashMap<>(size);
            for (Strategy strategy : strategyList) {
                map.put(strategy.getType(), strategy);
            }
            strategyMap = Collections.unmodifiableMap(map);
        }
    }
    ...
}
```

### 对象&类
##### 2.1 禁止使用JSON转化对象
1. JSON提供把对象转化为JSON字符串、把JSON字符串转为对象的功能，于是被某些人用来转化对象。这种对象转化方式，虽然在功能上没有问题，但是在性能上却存在问题。
2. 推荐手动转换
##### 2.2 尽量不使用反射赋值对象
1. 用反射赋值对象，主要优点是节省了代码量，主要缺点却是性能有所下降。
##### 2.3 采用Lambda表达式替换内部匿名类
1. 对于大多数刚接触JDK8的同学来说，都会认为Lambda表达式就是匿名内部类的语法糖。实际上， Lambda表达式在大多数虚拟机中采用invokeDynamic指令实现，相对于匿名内部类在效率上会更高一些。
##### 2.4 尽量避免定义不必要的子类
1. 多一个类就需要多一份类加载，所以尽量避免定义不必要的子类。
```
public static final Map<String, Class> CLASS_MAP =
    Collections.unmodifiableMap(new HashMap<String, Class>(16) {
    private static final long serialVersionUID = 1L;
    {
        put("VARCHAR", java.lang.String.class);
    }
});

public static final Map<String, Class> CLASS_MAP;
static {
    Map<String, Class> classMap = new HashMap<>(16);
    classMap.put("VARCHAR", java.lang.String.class);
    ...
    CLASS_MAP = Collections.unmodifiableMap(classMap);
}
```
##### 2.5尽量指定类的final修饰符
1. 为类指定final修饰符，可以让该类不可以被继承。如果指定了一个类为final，则该类所有的方法都是final的，Java编译器会寻找机会内联所有的final方法。内联对于提升Java运行效率作用重大，具体可参见Java运行期优化，能够使性能平均提高50%。
2. 注意：使用Spring的AOP特性时，需要对Bean进行动态代理，如果Bean类添加了final修饰，会导致异常。

### 方法
##### 3.1 把跟类成员变量无关的方法声明成静态方法
1. 静态方法的好处就是不用生成类的实例就可以直接调用。静态方法不再属于某个对象，而是属于它所在的类。只需要通过其类名就可以访问，不需要再消耗资源去反复创建对象。即便在类内部的私有方法，如果没有使用到类成员变量，也应该声明为静态方法。
##### 3.2尽量使用基本数据类型作为方法参数类型，避免不必要的装箱、拆箱和空指针
```
public static double sum(Double value1, Double value2) {
    double double1 = Objects.isNull(value1) ? 0.0D : value1;
    double double2 = Objects.isNull(value2) ? 0.0D : value2;
    return double1 + double2;
}
double result = sum(1.0D, 2.0D);

public static double sum(double value1, double value2) {
    return value1 + value2;
}
double result = sum(1.0D, 2.0D);
```
##### 3.3 尽量使用基本数据类型作为方法返回值类型，避免不必要的装箱、拆箱和空指针判断
1. 在JDK类库的方法中，很多方法返回值都采用了基本数据类型，首先是为了避免不必要的装箱和拆箱，其次是为了避免返回值的空指针判断。比如：Collection.isEmpty()和Map.size()。
##### 3.4 协议方法参数值非空，避免不必要的空指针判断
1. 协议编程，可以@NonNull和@Nullable标注参数，是否遵循全凭调用者自觉。
```
public static boolean isValid(UserDO user) {
    if (Objects.isNull(user)) {
        return false;
    }
  return Boolean.TRUE.equals(user.getIsValid());
}

public static boolean isValid(@NonNull UserDO user) {
  return Boolean.TRUE.equals(user.getIsValid());
}
```
##### 3.5协议方法返回值非空，避免不必要的空指针判断
```
// 定义接口
public interface OrderService {
    public List<OrderVO> queryUserOrder(Long userId);
}
// 调用代码
List<OrderVO> orderList = orderService.queryUserOrder(userId);
if (CollectionUtils.isNotEmpty(orderList)) {
    for (OrderVO order : orderList) {
        ...
    }
}

// 定义接口
public interface OrderService {
    @NonNull
    public List<OrderVO> queryUserOrder(Long userId);
}
// 调用代码
List<OrderVO> orderList = orderService.queryUserOrder(userId);
for (OrderVO order : orderList) {
    ...
}
```
##### 3.6 被调用方法已支持判空处理，调用方法无需再进行判空处理
```
UserDO user = null;
if (StringUtils.isNotBlank(value)) {
    user = JSON.parseObject(value, UserDO.class);
}

UserDO user = JSON.parseObject(value, UserDO.class);
```
##### 3.7 尽量避免不必要的函数封装
1. 方法调用会引起入栈和出栈，导致消耗更多的CPU和内存，应当尽量避免不必要的函数封装。当然，为了使代码更简洁、更清晰、更易维护，增加一定的方法调用所带来的性能损耗是值得的。
```
// 函数封装
public static boolean isVip(Boolean isVip) {
    return Boolean.TRUE.equals(isVip);
}
// 使用代码
boolean isVip = isVip(user.getVip());

boolean isVip = Boolean.TRUE.equals(user.getVip());
```
##### 3.8 尽量指定方法的final修饰符
1. 方法指定final修饰符，可以让方法不可以被重写，Java编译器会寻找机会内联所有的final方法。内联对于提升Java运行效率作用重大，具体可参见Java运行期优化，能够使性能平均提高50%。
1. **注意：所有的private方法会隐式地被指定final修饰符，所以无须再为其指定final修饰符。**

### 4.表达式
##### 4.1 尽量减少方法的重复调用
```
List<UserDO> userList = ...;
for (int i = 0; i < userList.size(); i++) {
    ...
}

List<UserDO> userList = ...;
int userLength = userList.size();
for (int i = 0; i < userLength; i++) {
    ...
}
```
##### 4.2 尽量避免不必要的方法调用
```
List<UserDO> userList = userDAO.queryActive();
if (isAll) {
    userList = userDAO.queryAll();
}

List<UserDO> userList;
if (isAll) {
    userList = userDAO.queryAll();
} else {
    userList = userDAO.queryActive();
}
```
##### 4.3 尽量使用移位来代替正整数乘除
1. 用移位操作可以极大地提高性能。对于乘除2^n(n为正整数)的正整数计算，可以用移位操作来代替。
```
int num1 = a * 4;
int num2 = a / 4;

int num1 = a << 2;
int num2 = a >> 2;
```
##### 4.4 提取公共表达式，避免重复计算
1. 提取公共表达式，只计算一次值，然后重复利用值。
```
double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

double dx = x2 - x1;
double dy = y2 - y1;
double distance = Math.sqrt(dx * dx + dy * dy);
或
double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
```
##### 4.5 尽量不在条件表达式中用!取反
1. 使用!取反会多一次计算，如果没有必要则优化掉。
```
if (!(a >= 10)) {
    ... // 条件处理1
} else {
    ... // 条件处理2
}

if (a < 10) {
    ... // 条件处理1
} else {
    ... // 条件处理2
}
```
##### 4.6 对于多常量选择分支，尽量使用switch语句而不是if-else语句
1. if-else语句，每个if条件语句都要加装计算，直到if条件语句为true为止。switch语句进行了跳转优化，Java中采用tableswitch或lookupswitch指令实现，对于多常量选择分支处理效率更高。经过试验证明：在每个分支出现概率相同的情况下，低于5个分支时if-else语句效率更高，高于5个分支时switch语句效率更高。
2. 备注：如果业务复杂，可以采用Map实现策略模式。

### 5.字符串
##### 5.1 尽量不要使用正则表达式匹配
1. 正则表达式匹配效率较低，尽量使用字符串匹配操作。
```
String source = "a::1,b::2,c::3,d::4";
String target = source.replaceAll("::", "=");
String[] targets = source.spit("::");

String source = "a::1,b::2,c::3,d::4";
String target = source.replace("::", "=");
String[] targets = StringUtils.split(source, "::");
```
##### 5.2 尽量使用字符替换字符串
```
String source = "a:1,b:2,c:3,d:4";
int index = source.indexOf(":");
String target = source.replace(":", "=");

String source = "a:1,b:2,c:3,d:4";
int index = source.indexOf(':');
String target = source.replace(':', '=');
```
##### 5.3 尽量使用StringBuilder进行字符串拼接
1. String是final类，内容不可修改，所以每次字符串拼接都会生成一个新对象。StringBuilder在初始化时申请了一块内存，以后的字符串拼接都在这块内存中执行，不会申请新内存和生成新对象。
##### 5.4 不要使用""+转化字符串
1. 使用""+进行字符串转化，使用方便但是效率低，建议使用String.valueOf.
```
int i = 12345;
String s = "" + i;

int i = 12345;
String s = String.valueOf(i);
```

### 6.数组
##### 6.1 不要使用循环拷贝数组，尽量使用System.arraycopy拷贝数组
```
int[] sources = new int[] {1, 2, 3, 4, 5};
int[] targets = new int[sources.length];
for (int i = 0; i < targets.length; i++) {
    targets[i] = sources[i];
}

int[] sources = new int[] {1, 2, 3, 4, 5};
int[] targets = new int[sources.length];
System.arraycopy(sources, 0, targets, 0, targets.length);
```
##### 6.2 集合转化为类型T数组时，尽量传入空数组T[0]
1. 将集合转换为数组有2种形式：toArray(new T[n])和toArray(new T[0])。在旧的Java版本中，建议使用toArray(new T[n])，因为创建数组时所需的反射调用非常慢。在OpenJDK6后，反射调用是内在的，使得性能得以提高，toArray(new T[0])比toArray(new T[n])效率更高。此外，toArray(new T[n])比toArray(new T[0])多获取一次列表大小，如果计算列表大小耗时过长，也会导致toArray(new T[n])效率降低。
2. 建议：集合应该提供一个toArray(Class<T> clazz)方法，避免无用的空数组初始化（new T[0]）。
```
List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, ...);
Integer[] integers = integerList.toArray(new Integer[integerList.size()]);

List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, ...);
Integer[] integers = integerList.toArray(new Integer[0]); // 勿用new Integer[]{}
```
##### 6.3 集合转化为Object数组时，尽量使用toArray()方法
1. 转化Object数组时，没有必要使用toArray[new Object[0]]，可以直接使用toArray()。避免了类型的判断，也避免了空数组的申请，所以效率会更高。
```
List<Object> objectList = Arrays.asList(1, "2", 3, "4", 5, ...);
Object[] objects = objectList.toArray(new Object[0]);

List<Object> objectList = Arrays.asList(1, "2", 3, "4", 5, ...);
Object[] objects = objectList.toArray();
```

### 7.集合
##### 7.1.初始化集合时，尽量指定集合大小
1. Java集合初始化时都会指定一个默认大小，当默认大小不再满足数据需求时就会扩容，每次扩容的时间复杂度有可能是O(n)。所以，尽量指定预知的集合大小，就能避免或减少集合的扩容次数。
```
List<UserDO> userDOList = ...;
Set<Long> userSet = new HashSet<>();
Map<Long, UserDO> userMap = new HashMap<>();
List<UserVO> userList = new ArrayList<>();
for (UserDO userDO : userDOList) {
    userSet.add(userDO.getId());
    userMap.put(userDO.getId(), userDO);
    userList.add(transUser(userDO));
}

List<UserDO> userDOList = ...;
int userSize = userDOList.size();
Set<Long> userSet = new HashSet<>(userSize);
Map<Long, UserDO> userMap = new HashMap<>((int) Math.ceil(userSize * 4.0 / 3));
List<UserVO> userList = new ArrayList<>(userSize);
for (UserDO userDO : userDOList) {
    userSet.add(userDO.getId());
    userMap.put(userDO.getId(), userDO);
    userList.add(transUser(userDO));
}
```
##### 7.2 不要使用循环拷贝集合，尽量使用JDK提供的方法拷贝集合
1. JDK提供的方法可以一步指定集合的容量，避免多次扩容浪费时间和空间。同时，这些方法的底层也是调用System.arraycopy方法实现，进行数据的批量拷贝效率更高。
```
List<UserDO> user1List = ...;
List<UserDO> user2List = ...;
List<UserDO> userList = new ArrayList<>(user1List.size() + user2List.size());
for (UserDO user1 : user1List) {
    userList.add(user1);
}
for (UserDO user2 : user2List) {
    userList.add(user2);
}

List<UserDO> user1List = ...;
List<UserDO> user2List = ...;
List<UserDO> userList = new ArrayList<>(user1List.size() + user2List.size());
userList.addAll(user1List);
userList.addAll(user2List);
```
##### 7.3 尽量使用Arrays.asList转化数组为列表
1. 原理与"不要使用循环拷贝集合，尽量使用JDK提供的方法拷贝集合"类似。
```
List<String> typeList = new ArrayList<>(8);
typeList.add("Short");
typeList.add("Integer");
typeList.add("Long");

String[] names = ...;
List<String> nameList = ...;
for (String name : names) {
    nameList.add(name);
}

List<String> typeList = Arrays.asList("Short", "Integer", "Long");

String[] names = ...;
List<String> nameList = ...;
nameList.addAll(Arrays.asList(names));
```
##### 7.4 直接迭代需要使用的集合
1. 直接迭代需要使用的集合，无需通过其它操作获取数据。
```
Map<Long, UserDO> userMap = ...;
for (Long userId : userMap.keySet()) {
    UserDO user = userMap.get(userId);
    ...
}

Map<Long, UserDO> userMap = ...;
for (Map.Entry<Long, UserDO> userEntry : userMap.entrySet()) {
    Long userId = userEntry.getKey();
    UserDO user = userEntry.getValue();
    ...
}
```
##### 7.5 不要使用size方法检测空，必须使用isEmpty方法检测空
1. 使用size方法来检测空逻辑上没有问题，但使用isEmpty方法使得代码更易读，并且可以获得更好的性能。任何isEmpty方法实现的时间复杂度都是O(1)，但是某些size方法实现的时间复杂度有可能是O(n)。
```
List<UserDO> userList = ...;
if (userList.size() == 0) {
    ...
}
Map<Long, UserDO> userMap = ...;
if (userMap.size() == 0) {
    ...
}

List<UserDO> userList = ...;
if (userList.isEmpty()) {
    ...
}
Map<Long, UserDO> userMap = ...;
if (userMap.isEmpty()) {
    ...
}
```
##### 7.6 非随机访问的List，尽量使用迭代代替随机访问
1. 对于列表，可分为随机访问和非随机访问两类，可以用是否实现RandomAccess接口判断。随机访问列表，直接通过get获取数据不影响效率。而非随机访问列表，通过get获取数据效率极低。
2. 其实，不管列表支不支持随机访问，都应该使用迭代进行遍历。
```
LinkedList<UserDO> userDOList = ...;
int size = userDOList.size();
for (int i = 0; i < size; i++) {
    UserDO userDO = userDOList.get(i);
    ...
}

LinkedList<UserDO> userDOList = ...;
for (UserDO userDO : userDOList) {
    ...
}
```
##### 7.7 尽量使用HashSet判断值存在
1. 在Java集合类库中，List的contains方法普遍时间复杂度是O(n)，而HashSet的时间复杂度为O(1)。如果需要频繁调用contains方法查找数据，可以先将List转换成HashSet。
```
List<Long> adminIdList = ...;
List<UserDO> userDOList = ...;
List<UserVO> userVOList = new ArrayList<>(userDOList.size());
for (UserDO userDO : userDOList) {
    if (adminIdList.contains(userDO.getId())) {
        userVOList.add(transUser(userDO));
    }
}

Set<Long> adminIdSet = ...;
List<UserDO> userDOList = ...;
List<UserVO> userVOList = new ArrayList<>(userDOList.size());
for (UserDO userDO : userDOList) {
    if (adminIdSet.contains(userDO.getId())) {
        userVOList.add(transUser(userDO));
    }
}
```
##### 7.8 避免先判断存在再进行获取
1. 如果需要先判断存在再进行获取，可以直接获取并判断空，从而避免了二次查找操作。
```
public static UserVO transUser(UserDO user, Map<Long, RoleDO> roleMap) {
    UserVO userVO = new UserVO();
    userVO.setId(user.getId());
    ...
    if (roleMap.contains(user.getRoleId())) {
        RoleDO role = roleMap.get(user.getRoleId());
        userVO.setRole(transRole(role));
    }
}

public static UserVO transUser(UserDO user, Map<Long, RoleDO> roleMap) {
    UserVO userVO = new UserVO();
    userVO.setId(user.getId());
    ...
    RoleDO role = roleMap.get(user.getRoleId());
    if (Objects.nonNull(role)) {
        userVO.setRole(transRole(role));
    }
}
```

### 8.异常
##### 8.1 直接捕获对应的异常
1. 直接捕获对应的异常，避免用instanceof判断，效率更高代码更简洁。
```
try {
    saveData();
} catch (Exception e) {
    if (e instanceof IOException) {
        log.error("保存数据IO异常", e);
    } else {
        log.error("保存数据其它异常", e);
    }
}

try {
    saveData();
} catch (IOException e) {
    log.error("保存数据IO异常", e);
} catch (Exception e) {
    log.error("保存数据其它异常", e);
}
```
##### 8.2尽量避免在循环中捕获异常
1. 当循环体抛出异常后，无需循环继续执行时，没有必要在循环体中捕获异常。因为，过多的捕获异常会降低程序执行效率。
```
public Double sum(List<String> valueList) {
    double sum = 0.0D;
    for (String value : valueList) {
        try {
            sum += Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    return sum;
}

public Double sum(List<String> valueList) {
    double sum = 0.0D;
    try {
        for (String value : valueList) {
            sum += Double.parseDouble(value);
        }
    } catch (NumberFormatException e) {
        return null;
    }
    return sum;
}
```
##### 8.3 禁止使用异常控制业务流程
1. 相对于条件表达式，异常的处理效率更低。
```
public static boolean isValid(UserDO user) {
    try {
        return Boolean.TRUE.equals(user.getIsValid());
    } catch(NullPointerException e) {
        return false;
    }
}

public static boolean isValid(UserDO user) {
    if (Objects.isNull(user)) {
        return false;
    }
  return Boolean.TRUE.equals(user.getIsValid());
}
```

### 9.缓冲区
##### 9.1 初始化时尽量指定缓冲区大小
1. 初始化时，指定缓冲区的预期容量大小，避免多次扩容浪费时间和空间。
```
StringBuffer buffer = new StringBuffer();
StringBuilder builder = new StringBuilder();

StringBuffer buffer = new StringBuffer(1024);
StringBuilder builder = new StringBuilder(1024);
```
##### 9.2 尽量重复使用同一缓冲区
1. 针对缓冲区，Java虚拟机需要花时间生成对象，还要花时间进行垃圾回收处理。所以，尽量重复利用缓冲区。
```
StringBuilder builder1 = new StringBuilder(128);
builder1.append("update t_user set name = '").append(userName).append("' where id = ").append(userId);
statement.executeUpdate(builder1.toString());
StringBuilder builder2 = new StringBuilder(128);
builder2.append("select id, name from t_user where id = ").append(userId);
ResultSet resultSet = statement.executeQuery(builder2.toString());
...

StringBuilder builder = new StringBuilder(128);
builder.append("update t_user set name = '").append(userName).append("' where id = ").append(userId);
statement.executeUpdate(builder.toString());
builder.setLength(0);
builder.append("select id, name from t_user where id = ").append(userId);
ResultSet resultSet = statement.executeQuery(builder.toString());
...
其中，使用setLength方法让缓冲区重新从0开始。
```
##### 9.3 尽量设计使用同一缓冲区
1. 为了提高程序运行效率，在设计上尽量使用同一缓冲区。
```
// 转化XML(UserDO)
public static String toXml(UserDO user) {
    StringBuilder builder = new StringBuilder(128);
    builder.append("<UserDO>");
    builder.append(toXml(user.getId()));
    builder.append(toXml(user.getName()));
    builder.append(toXml(user.getRole()));
    builder.append("</UserDO>");
    return builder.toString();
}
// 转化XML(Long)
public static String toXml(Long value) {
    StringBuilder builder = new StringBuilder(128);
    builder.append("<Long>");
    builder.append(value);
    builder.append("</Long>");
    return builder.toString();
}
...
// 使用代码
UserDO user = ...;
String xml = toXml(user);

// 转化XML(UserDO)
public static void toXml(StringBuilder builder, UserDO user) {
    builder.append("<UserDO>");
    toXml(builder, user.getId());
    toXml(builder, user.getName());
    toXml(builder, user.getRole());
    builder.append("</UserDO>");
}
// 转化XML(Long)
public static void toXml(StringBuilder builder, Long value) {
    builder.append("<Long>");
    builder.append(value);
    builder.append("</Long>");
}
...
// 使用代码
UserDO user = ...;
StringBuilder builder = new StringBuilder(1024);
toXml(builder, user);
String xml = builder.toString();
去掉每个转化方法中的缓冲区申请，申请一个缓冲区给每个转化方法使用。从时间上来说，节约了大量缓冲区的申请释放时间；从空间上来说，节约了大量缓冲区的临时存储空间。
```
##### 9.4 尽量使用缓冲流减少IO操作
1. 使用缓冲流BufferedReader、BufferedWriter、BufferedInputStream、BufferedOutputStream等，可以大幅较少IO次数并提升IO速度。
```
try (FileInputStream input = new FileInputStream("a");
    FileOutputStream output = new FileOutputStream("b")) {
    int size = 0;
    byte[] temp = new byte[1024];
    while ((size = input.read(temp)) != -1) {
        output.write(temp, 0, size);
    }
} catch (IOException e) {
    log.error("复制文件异常", e);
}

try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("a"));
    BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("b"))) {
    int size = 0;
    byte[] temp = new byte[1024];
    while ((size = input.read(temp)) != -1) {
        output.write(temp, 0, size);
    }
} catch (IOException e) {
    log.error("复制文件异常", e);
}
其中，可以根据实际情况手动指定缓冲流的大小，把缓冲流的缓冲作用发挥到最大。
@param   in     the underlying input stream.
@param   size   the buffer size.
public BufferedInputStream(InputStream in, int size) 
```

### 10.线程
##### 10.1 在单线程中，尽量使用非线程安全类
1. 使用非线程安全类，避免了不必要的同步开销。
```
StringBuffer buffer = new StringBuffer(128);
buffer.append("select * from ").append(T_USER).append(" where id = ?");

StringBuilder buffer = new StringBuilder(128);
buffer.append("select * from ").append(T_USER).append(" where id = ?");
```
##### 10.2 在多线程中，尽量使用线程安全类
1. 使用线程安全类，比自己实现的同步代码更简洁更高效。
```
private volatile int counter = 0;
public void access(Long userId) {
    synchronized (this) {
        counter++;
    }
    ...
}

private final AtomicInteger counter = new AtomicInteger(0);
public void access(Long userId) {
    counter.incrementAndGet();
    ...
}
```
##### 10.3 尽量减少同步代码块范围
1. 在一个方法中，可能只有一小部分的逻辑是需要同步控制的，如果同步控制了整个方法会影响执行效率。所以，尽量减少同步代码块的范围，只对需要进行同步的代码进行同步。
```
private volatile int counter = 0;
public synchronized void access(Long userId) {
  counter++;
    ... // 非同步操作
}

private volatile int counter = 0;
public void access(Long userId) {
    synchronized (this) {
        counter++;
    }
    ... // 非同步操作
}
```
##### 10.4 尽量合并为同一同步代码块
1. 同步代码块是有性能开销的，如果确定可以合并为同一同步代码块，就应该尽量合并为同一同步代码块。
```
// 处理单一订单
public synchronized handleOrder(OrderDO order) {
    ...
}
// 处理所有订单
public void handleOrder(List<OrderDO> orderList) {
    for (OrderDO order : orderList) {
        handleOrder(order);
    }
}

// 处理单一订单
public handleOrder(OrderDO order) {
    ...
}
// 处理所有订单
public synchronized void handleOrder(List<OrderDO> orderList) {
    for (OrderDO order : orderList) {
        handleOrder(order);
    }
}
```
##### 10.5 尽量使用线程池减少线程开销
1. 多线程中两个必要的开销：线程的创建和上下文切换。采用线程池，可以尽量地避免这些开销。
```
public void executeTask(Runnable runnable) {
    new Thread(runnable).start();
}

private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
public void executeTask(Runnable runnable) {
    executorService.execute(runnable);
}
```

## NOTE
1. 1.6、7 不可变的静态常量、成员变量，尽量使用非线程安全类
2. 2.5 尽量指定类的final修饰符 Java编译器会寻找机会内联所有的final方法
3. 3.4 协议编程 @NonNull和@Nullable 标注方法参数和返回值
4. 4.3 int num1 = a << 2;   int num2 = a >> 2;
5. 4.6 switch语句进行了跳转优化，Java中采用tableswitch或lookupswitch指令实现，对于多常量选择分支处理效率更高
6. 5.1 StringUtils.split(source, "::");
7. 6.2 集合应该提供一个toArray(Class  clazz)方法，避免无用的空数组初始化（new T[0]）
8. 7.1 new HashMap<>((int) Math.ceil(userSize * 4.0 / 3));






















































