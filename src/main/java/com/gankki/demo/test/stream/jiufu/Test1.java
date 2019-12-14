package com.gankki.demo.test.stream.jiufu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author liuhao
 * @date 2019/12/14
 */
public class Test1 {


    public static void main(String[] args){
        Map<String, List<Student>> stuMap = new HashMap<>();
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(null);
        studentsList.add(null);
        studentsList.add(null);

        for (Student stu: studentsList) {
            if ( stu != null) {// 非空
                if (stu.getHeight() > 160) { // 身高大于160
                    if (stuMap.get(stu.getSex()) == null) { // 该性别还没分类
                        List<Student> list = new ArrayList<>(); // 新建该性别学生的列表
                        list.add(stu);// 将学生放进去列表
                        stuMap.put(stu.getSex(), list);// 将列表放到map中
                    } else { // 该性别分类已存在
                        stuMap.get(stu.getSex()).add(stu);// 该性别分类已存在，则直接放进去即可
                    }
                }
            }
        }

    }

}
