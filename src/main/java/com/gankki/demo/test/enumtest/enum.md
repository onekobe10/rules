# 枚举 Enum

1. 每个枚举类都是 java.lang.Enum 抽象类的子类

2. Enum 有两个属性，name 和 ordinal,分别表示了枚举的名字和顺序

3. 枚举的构造方法默认都是private


枚举类转换为具体类的实现大致为：
```
public final class Size extends Enum<Size> {
    public static final Size SMALL = new Size("SMALL",0);
    public static final Size MEDIUM = new Size("MEDIUM",1);
    public static final Size LARGE = new Size("LARGE",2);
    
    private static Size[] VALUES =
            new Size[]{SMALL,MEDIUM,LARGE};
    
    private Size(String name, int ordinal){
        super(name, ordinal);
    }
    
    public static Size[] values(){
        Size[] values = new Size[VALUES.length];
        System.arrayCopy(VALUES, 0,
                values, 0, VALUES.length);
        return values;
    }
    
    public static Size valueOf(String name){
        return Enum.valueOf(Size.class, name);
    }
}
```
