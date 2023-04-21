package com.gankki.demo.test.stream.dupkey;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuhao
 * @date 2020/2/18
 */
public class MapDupKeyTest {


    public static void main(String[] args) {
        /*List<Entity> list = new ArrayList<>();
        list.add(new Entity("20170728120", 1));
        list.add(new Entity("20170728119", 3));
        list.add(new Entity("20170728119", 2));
        list.add(new Entity("20170728119", 4));*/

        //Map<String, Integer> map = list.stream().collect(Collectors.toMap(Entity::getKey, Entity::getValue));
        //map.entrySet().stream().forEach(e -> System.out.println(e.getValue()));
        /*Map<String, Integer> map2 = list.stream().collect(
                Collectors.toMap(Entity::getKey, Entity::getValue, (s, a) -> {
                    System.out.println(s + ".." + a);
                    return s + a;
                }));
        map2.entrySet().stream().forEach(e -> System.out.println(e.getValue()));*/
        // key 重复 java.lang.IllegalStateException: Duplicate key 3
        // mergeFunction 可以对重复的value进行处理
        // 这种写法可以让将重复的key集合在一起
        /*
         Map<String, List<TradeRecordEntity>> tradeRecordMap = selectListByConfirmShare.stream()
                        .collect(Collectors.toMap(s -> s.getTradedate().toLocalDate().format(fmt)
                                , t -> {
                                    List<TradeRecordEntity> valueList = new ArrayList<>();
                                    valueList.add(t);
                                    return valueList;
                                }, (List<TradeRecordEntity> first, List<TradeRecordEntity> second) -> {
                                    first.addAll(second);
                                    return first;
                                }));
          Map<String, List<String>> map = list.stream().collect(Collectors.toMap(Student::getClassName,
                // 此时的value 为集合，方便重复时操作
                s -> {
                    List<String> studentNameList = new ArrayList<>();
                    studentNameList.add(s.getStudentName());
                    return studentNameList;
    },
        // 重复时将现在的值全部加入到之前的值内
        (List<String> value1, List<String> value2) -> {
            value1.addAll(value2);
            return value1;
   }
        ));

         */


        User user1 = new User();
        user1.setUserName("1");
        user1.setPassword("1");

        User user2 = new User();
        user2.setUserName("1");
        user2.setPassword("2");

        User user3 = new User();
        user3.setUserName("3");
        user3.setPassword("3");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // groupingBy 是 Collectors.map 平替
        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getUserName));

        System.out.println(JSON.toJSONString(collect));

    }

    @Data
    public static class User {
        private String userName;

        private String password;
    }

}
