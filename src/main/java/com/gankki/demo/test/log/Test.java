package com.gankki.demo.test.log;

/**
 *@desc 日志
 *@author liuhao
 *@createDate 2019/9/2
 */
public class Test {


    public static void main(String[] args){
        try {
            Integer i = null;
            i.toString();
        } catch (Throwable e) {// Exception 捕获不到 error 异常，建议使用 Throwable 可以 catch 到所有类型的异常
            // 此种方式的异常没有日期信息和异常等级，不推荐。
            e.printStackTrace();
        }
        // 打点：在程序的关键执行链路中打一个日志（打点），记录用户的行为
        // 利用 kafka 将用户的行为信息收集起来，放到实时流式处理平台(Storm/Flink)上清洗/过滤。如果是实时需要用到的放到 Redis，离线的放在 Hive。
    }

}
