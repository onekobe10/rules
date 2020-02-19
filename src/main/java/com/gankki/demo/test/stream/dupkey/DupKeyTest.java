package com.gankki.demo.test.stream.dupkey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuhao
 * @date 2020/2/18
 */
public class DupKeyTest {


    public static void main(String[] args) {
        List<Entity> list = new ArrayList<>();
        list.add(new Entity("20170728120", 1));
        list.add(new Entity("20170728119", 3));
        list.add(new Entity("20170728119", 2));
        list.add(new Entity("20170728119", 4));

        //Map<String, Integer> map = list.stream().collect(Collectors.toMap(Entity::getKey, Entity::getValue));
        //map.entrySet().stream().forEach(e -> System.out.println(e.getValue()));
        Map<String, Integer> map2 = list.stream().collect(
                Collectors.toMap(Entity::getKey, Entity::getValue, (s, a) -> {
                    System.out.println(s + ".."  + a);
                    return s + a;
                } ));
        map2.entrySet().stream().forEach(e -> System.out.println(e.getValue()));
        // key 重复 java.lang.IllegalStateException: Duplicate key 3
        // mergeFunction 可以对重复的value进行处理
    }

}
