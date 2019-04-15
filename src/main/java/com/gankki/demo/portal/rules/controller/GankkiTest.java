package com.gankki.demo.portal.rules.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *@desc 日常测试使用类
 *@author liuhao
 *@createDate 2018/9/17
 */
public class GankkiTest {



    public static void main(String[] args){
        String str = "test";
        String[] strArr = str.split(",");
        System.out.println(strArr.length + "..." + strArr[0]);

        System.out.println("-1".contains("-"));
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String st = iterator.next();
            st = "ccc";
        }

        System.out.println(list.get(0));

        String path = "/download/幅度萨芬";
        System.out.println(path.lastIndexOf("/"));
        System.out.println(path.substring(path.lastIndexOf("/") + 1, path.length()));

    }

    // <? extends T> 和 <? super T> 测试
    public void upperBound(List<? extends Date> list, Date date){
        Date now = list.get(0);
        System.out.println("now==>" + now);
        //list.add(date); //这句话无法编译
        list.add(null);//这句可以编译，因为null没有类型信息
    }

    public void  testUpperBound(){
        List<Timestamp> list = new ArrayList<>();
        Date date = new Date();
        upperBound(list,date);
    }


    public void lowerBound(List<? super Timestamp> list)
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        list.add(now);
        //Timestamp time = list.get(0); //不能编译
    }

    public void testLowerBound()
    {
        List<Date> list = new ArrayList<>();
        list.add(new Date());
        lowerBound(list);
    }
    // <? extends T> 和 <? super T> 测试


}
class Employee{}
class Manager extends Employee{}
