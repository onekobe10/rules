package com.gankki.demo.test.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/15
 */
public class StreamSortTest {

    public static void main(String[] args){
        List<SortedObject> list = new ArrayList<>();
        SortedObject s1 = new SortedObject();
        s1.setLocalDate(LocalDate.parse("2019-10-12"));
        s1.setBigDecimal(new BigDecimal("1.20"));
        list.add(s1);
        SortedObject s2 = new SortedObject();
        s2.setBigDecimal(new BigDecimal("3.20"));
        s2.setLocalDate(LocalDate.parse("2019-10-12"));
        list.add(s2);
        SortedObject s3 = new SortedObject();
        s3.setBigDecimal(new BigDecimal("0.20"));
        s3.setLocalDate(LocalDate.parse("2019-10-13"));
        list.add(s3);

        // Stream 中的 sorted 方法默认是正序排序
        // 这种写法是错误的，在thenComparing外调用reversed()方法，就相当于对整体倒叙
        List<SortedObject> list2 = list.stream().sorted(
                Comparator.comparing(SortedObject::getLocalDate).reversed().
                        thenComparing(SortedObject::getBigDecimal).reversed()).collect(Collectors.toList());
        // 这种写法是正确的，必须在thenComparing中调用reversed()方法
        List<SortedObject> list3 = list.stream().sorted(
                Comparator.comparing(SortedObject::getLocalDate).reversed().
                        thenComparing(Comparator.comparing(SortedObject::getBigDecimal).reversed())).collect(Collectors.toList());
        list2.forEach( t ->{
            System.out.println(t.getLocalDate() + ".........." + t.getBigDecimal());
        });

        System.out.println("---------------------------------");

        list3.forEach( t ->{
            System.out.println(t.getLocalDate() + ".........." + t.getBigDecimal());
        });
    }

    private static class SortedObject{
        private BigDecimal bigDecimal;
        private LocalDate localDate;

        public BigDecimal getBigDecimal() {
            return bigDecimal;
        }

        public void setBigDecimal(BigDecimal bigDecimal) {
            this.bigDecimal = bigDecimal;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }
    }

}
