package com.gankki.demo.test.stream.jiufu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author liuhao
 * @date 2019/12/14
 */
public class Test3 {

    public static void main(String[] args){
        List<Student> stuList = new ArrayList<>();
        stuList.add(null);
        stuList.add(null);
        stuList.add(null);

        Predicate<Student> predicate = Objects::nonNull;
        Predicate<Student> predicate2 = (Student s) -> s.getHeight() > 160;
        Consumer<Student> consumer = System.out::println;

        stuList.stream()
                .filter(predicate)
                .filter(predicate2)
                .forEach(consumer);
    }

}
