package com.gankki.demo.note150.anonymousinnerclassandsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@desc   排序的两种方式之一，实体类实现Comparable接口
 *@author liuhao
 *@createDate 2018/11/25
 */
public class Students implements  Comparable<Students>{
    private Integer age;

    public Students(Integer i){
        this.age = i;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Students s) {
        return this.age - s.age;
    }


    public static void main(String[] args){
        Students s1 = new Students(1);
        Students s2 = new Students(5);
        Students s3 = new Students(2);
        List<Students> list = new ArrayList<>(3);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list);
        for (Students s: list) {
            System.out.println(s.getAge());
        }

    }
}
