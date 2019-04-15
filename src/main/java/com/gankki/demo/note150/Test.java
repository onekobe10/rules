package com.gankki.demo.note150;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@desc java 150面试题测试
 *@author liuhao
 *@createDate 2018/10/16
 */
public class Test {
    public String test = "测试";

    public static void testTransfer(Test test){
        test.test = "测试2";
    }

    public static void main(String[] args) throws Exception{
       /* 5
        short s1 = 1;
        // i为int s1 + 1 向上转型为int，int不能直接赋值给s1,只能强转
        s1  = (short) (s1 + 1);
        // += 相当于(short) (s1 + 1) 隐藏了一个强转
        s1 += 1;
        */

        /* 9
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        // intern() 返回此字符串对象在常量池中的引用，如果没有则把此对象添加进去并返回一个新的引用
        System.out.println(s2.intern() == s2);
        */

        /* 10
        // 原理 + 0.5 然后向下取整
        System.out.println(Math.round(11.6));
        System.out.println(Math.round(-11.6));
        */

        /*Test test = new Test();
        Test.testTransfer(test);
        System.out.println(test.test);

        // 分隔一个字符串，如果分隔符在字符串中不能匹配则返回原来的字符串
        String a = "sss";
        String[] b = a.split(",");
        for (String c : b) {
            System.out.println(c);
        }
        */

        // 获取年月日
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        // 0 - 11
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));

        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        // 1 - 12
        System.out.println(dt.getMonthValue());
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        // 获取毫秒数
        long millis1 = System.currentTimeMillis();
        long millis2 =Calendar.getInstance().getTimeInMillis();
        long millis3 =Clock.systemDefaultZone().millis();
        System.out.println(millis1 + "..." + millis2 + "..." + millis3);
        // 获取一个月中的最大一天
        Calendar time = Calendar.getInstance();
        Integer maxDayOfMonth = time.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maxDayOfMonth);
        // java8
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        // 打印昨天的同一时刻
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE,-1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(calendar2.getTime()));

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime yesterDay = localDateTime.minusDays(1);
        System.out.println(dateTimeFormatter.format(yesterDay));
        System.out.println(yesterDay);

        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }

        Map<String, String> testPrintMap = new HashMap<>(5);
        testPrintMap.put("a", "1");
        testPrintMap.put("c", "3");
        testPrintMap.put("b", "2");
        testPrintMap.put("e", "5");
        testPrintMap.put("d", "4");
        testPrintMap.forEach((k, v) -> System.out.println("key : " + k + "......1....value: " + v));
        for(String key : testPrintMap.keySet()) {
            System.out.println(key + "....2......." + testPrintMap.get(key));
        }
        for(Map.Entry<String,String> entry : testPrintMap.entrySet()){
            System.out.println(entry.getKey() + "......3......" + entry.getValue());
        }
    }
}
