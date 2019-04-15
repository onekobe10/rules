package com.gankki.demo.note150.anonymousinnerclassandsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuhao
 * @desc 排序的实现方式之二 通过一个实现了Comparator接口的实现类来定义排序规则的方式
 * @createDate 2018/11/25
 */
public class Students1 {
    private Integer a;

    public Students1(Integer i) {
        this.a = i;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }


    public static void main(String[] args) {
        Students1 s1 = new Students1(1);
        Students1 s2 = new Students1(5);
        Students1 s3 = new Students1(2);
        List<Students1> list = new ArrayList<>(3);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        // 比较器的实现类方式
        ComparatorUtil comparatorUtil = new ComparatorUtil();
        Collections.sort(list, comparatorUtil);
        for (Students1 s : list) {
            System.out.println(s.getA());
        }
        // 匿名内部类的方式
        Collections.sort(list, new Comparator<Students1>() {
            @Override
            public int compare(Students1 o1, Students1 o2) {
                return o1.getA() - o2.getA();
            }
        });
        for (Students1 s : list) {
            System.out.println(s.getA());
        }
        // lamda表达式方式实现
        Collections.sort(list, (Students1 q1, Students1 q2) -> (q1.getA() - q2.getA()));
        for (Students1 s : list) {
            System.out.println(s.getA());
        }
    }
}
