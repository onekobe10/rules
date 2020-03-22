package com.gankki.demo.optimization.design.future;

public interface Task<T, P> {
    T doTask(P param);//完成任务
}
