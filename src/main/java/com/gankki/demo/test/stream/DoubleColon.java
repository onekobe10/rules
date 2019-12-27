package com.gankki.demo.test.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liuhao
 * @desc 双冒号的使用
 * @createDate 2019/7/24
 */
@Data
public class DoubleColon {
    /**
     * 名字
     */
    private String name;

    public static void printStr(String str) {
        System.out.println("printStr : " + str);
    }

    public void toUpper() {
        System.out.println("toUpper : " + this.toString());
    }

    public void toLower(String str) {
        System.out.println("toLower : " + str);
    }

    public int toInt(String str) {
        System.out.println("toInt : " + str);
        return 1;
    }

    public int toInt2(DoubleColon str) {
        System.out.println("toInt : " + str);
        return 1;
    }

    /**
     * 1. 方法引用
     * 类名::方法名
     * 2. 构造方法
     * 类名::new
     * <p>
     * 用::提取的函数，最主要的区别在于静态与非静态方法，非静态方法比静态方法多一个参数，就是被调用的实例。
     * <p>
     * 根据入参的不同选择 Consumer BiConsumer
     */
    public static void main(String[] args) {
        Consumer<String> printStrConsumer = DoubleColon::printStr;
        printStrConsumer.accept("printStrConsumer");

        Consumer<DoubleColon> toUpperConsumer = DoubleColon::toUpper;
        toUpperConsumer.accept(new DoubleColon());

        BiConsumer<DoubleColon, String> toLowerConsumer = DoubleColon::toLower;
        toLowerConsumer.accept(new DoubleColon(), "toLowerConsumer");

        DoubleColon doubleColon = new DoubleColon();
        DoubleColon doubleColon2 = new DoubleColon();
        Function<DoubleColon, Integer> function1 = doubleColon::toInt2;
        function1.apply(doubleColon);
        function1.apply(doubleColon2);

        Function<DoubleColon, String> function2 = DoubleColon::getName;
        function2.apply(doubleColon);

        BiFunction<DoubleColon, String, Integer> function3 = DoubleColon::toInt;
        int i = function3.apply(new DoubleColon(), "toInt");

        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collected);
    }
}
