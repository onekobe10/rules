package com.gankki.demo.note150.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {


    public static void main(String[] args) throws Exception {
        // 获取类对象的三种方式
        Class class1 = String.class;
        Class class2 = "123".getClass();
        Class class3 = Class.forName("java.lang.String");
        // 通过反射创建对象
        String strReflect1 = String.class.newInstance();
        String strReflect2 = String.class.getConstructor(String.class).newInstance("123");
        System.out.println(strReflect2);

        // 通过反射获取对象的私有成员变量
        Car car = new Car();
        car.setBrand("Lexus");
        car.setName("Toyota");
        Field field = car.getClass().getDeclaredField("name");
        /**
         * 反射对象想修改或者修改私有的成员变量，只能调用setAccessible()方法置为true即可
         * java.lang.IllegalAccessException: Class com.boco.eoms.note150.reflect.ReflectTest
         * can not access a member of class com.boco.eoms.note150.reflect.Car with modifiers "private"
         */
        field.setAccessible(true);
        field.set(car, "Japan Toyota");
        System.out.println(field.get(car));
        System.out.println(car.toString());

        // 通过反射调用方法
        Method method = car.getClass().getMethod("getName");
        System.out.println(method.invoke(car));

    }
}
