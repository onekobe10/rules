# 日期格式

1. Java 8中新出的日期相关的类的，对12进制要求严格，使用十二进制时必须明确是上午还是下午,用a来标识格式中的上下午。
2. SimpleDateFormat中，对于12进制，没有明确上下午时依然可以解析，而在LocalTime中如果没有AM/PM的信息时，the LocalTime returned from the TemporalAccessor is null and hence you are getting Unable to obtain LocalTime from TemporalAccessor.也就是LocalTime对于上下午信息要求更严格了。

#### SimpleDateFormat

SimpleDateFormat并不是线程安全的,因为在SimpleDateFormat中持有一个Calendar类的实例calendar，而Calendar是线程不安全的，在Parse和Format方法时会调用calendar.setTime(date)/calb.establish(calendar).getTime()等方法都依赖于calendar实例,而Calendar类是线程不安全的，如果在多线程环境下运行,会出现线程安全问题,为了解决这个问题,可以使用以下方法: 
1. 需要的时候创建新实例 
2. 使用同步：同步SimpleDateFormat对象 
3. 使用ThreadLocal（在这个请求执行的过程中使用到SimpleDateFormat的地方都可以引用这个本地线程变量，只会实例化一次，而不是每个使用的地方都实例化） 
4. 抛弃JDK，使用其他类库中的时间格式化类,使用Apache commons 里的FastDateFormat,使用Joda-Time类库来处理时间相关问题 
5. 使用Java 8 新的日期格式工具类 DateTimeFormatter