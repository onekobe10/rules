package com.gankki.demo.test.stream.jiufu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author liuhao
 * @date 2019/12/14 
 */
public class Test2 {


    public static void main(String[] args){
        List<Student> stuList = new ArrayList<>();
        stuList.add(null);
        stuList.add(null);
        stuList.add(null);

        // 串行实现
        Map<String, List<Student>> stuMap1 = stuList.stream()
                .filter(Objects::nonNull)
                .filter((Student s) -> s.getHeight() > 160)
                .collect(Collectors.groupingBy(Student ::getSex));

        //并行实现
        Map<String, List<Student>> stuMap2 = stuList.stream().parallel()
                .filter(student -> student != null)
                .filter((Student s) -> s.getHeight() > 160)
                .collect(Collectors.groupingBy(Student ::getSex));

        Map<String, List<Student>> stuMap3 = stuList.parallelStream()
                .filter(Objects::nonNull)
                .filter((Student s) -> s.getHeight() > 160)
                .collect(Collectors.groupingBy(Student ::getSex));

    }
}
