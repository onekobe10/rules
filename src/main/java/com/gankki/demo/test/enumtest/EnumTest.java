package com.gankki.demo.test.enumtest;

import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author liuhao
 * @desc 枚举类的测试练习
 * @createDate 2018/10/7
 */
public enum EnumTest {

    // 枚举的实例 只能位于最前面
    RED(0, "红色") {
        @Override
        public String getColor() {
            System.out.println("重写方法");
            // 只能通过重写方法调用，不能在外部直接调用？？？
            testInner();
            return super.color;
        }

        // 自定义方法 不能显示的通过EnumTest.RED.testInner()获取
        // Red是EnmuTest的实例，而testInner是Red内部的方法，只有EnumTest的方法才可以显式调用
        // 枚举元素可以重写枚举的方法，可以在重写方法中调用自己的内部方法，但是不能通过枚举元素调用自己的内部方法
        public void testInner() {
            System.out.println("枚举元素内部方法测试");
        }
    }, BLUE(1, "蓝色"), GREEN(2, "绿色"), YELLOW(3, "黄色");

    // 属性
    private Integer index;
    private String color;

    // 默认就是private修饰的构造方法
    EnumTest(Integer index, String color) {
        this.index = index;
        this.color = color;
    }

    public Integer getIndex() {
        return this.index;
    }

    public String getColor() {
        return this.color;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * enum的使用：可以添加新的方法
     */
    public static void addMethodTest() {
        for (EnumTest e : EnumTest.values()) {
            if ("红色".equals(e.getColor())) {
                System.out.println("测试：红色");
            }
        }
    }

    @Override
    public String toString() {
        return this.index + ":" + this.color;
    }

    public static void main(String[] args) {
        //Enum
        // Enum的toString的逆方法
        EnumTest test = Enum.valueOf(EnumTest.class, "RED");
        System.out.println(test.toString());
        System.out.println(EnumTest.RED.getColor());
        // values方法返回一个包含所有枚举值的数组
        System.out.println(EnumTest.values()[2]);
        System.out.println(EnumTest.GREEN.ordinal());

        EnumTest.addMethodTest();
        System.out.println();
        for (EnumTest e : EnumTest.values()) {
            System.out.println(e.toString());
        }

        // 数据存储 数量有限 速度快
        // ***由于1EnumMap&EnumSet中的key为枚举类型这样导致了，map中的数量最多为枚举的元素个数
        // EnumMap
        // EnumMap中有三种构造方法 构造方法的参数明确了EnumMap中的key的限定，value无所谓
        // 1. key只有EnmuTest的类型
        EnumMap enumMap = new EnumMap(EnumTest.class);
        // 可以把一个EnumMap的实例作为参数
        EnumMap enumMap2 = new EnumMap(enumMap);
        // 也可以放置一个普通的map，map的key为枚举类型
        // Map map = new HashMap();
        // EnumMap enumMap3 = new EnumMap(map);
        // EnumSet 是一个抽象类，如果size小于64就返回RegularEnumSet private long elements（ long是一个64位的数据类型，类似可以用每一个位置的1或0来表示集合中是否存在此枚举）
        // 如果大于64就返回JumboEnumSet private long[] elements 看源码
        EnumSet enumSet = EnumSet.noneOf(EnumTest.class);

        Class enumClass = EnumTest.class;
        // java.lang.Enum
        System.out.println(enumClass.getSuperclass().getName());
        Method[] enumMethods = enumClass.getDeclaredMethods();
        // 父类中并没有values方法，此方法是在编译器编译时加上去的
        for (Method method : enumMethods) {
            System.out.println(method.getName());
        }
        // 每一个枚举元素的内部都包含所有的枚举元素
        EnumTest enumTest = EnumTest.RED;
        System.out.println(enumTest.getColor());
        for (EnumTest e : enumTest.values()) {
            System.out.println(e.getColor());
        }

        // 枚举的每一个元素是枚举的唯一实例，单例模式的最佳实践
    }
}
