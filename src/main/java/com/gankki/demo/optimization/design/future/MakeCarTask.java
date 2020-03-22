package com.gankki.demo.optimization.design.future;


public class MakeCarTask<T, P> implements Task<T, P> {

    @SuppressWarnings("unchecked")
    @Override
    public T doTask(P param) {

        String car = param + " is created success";

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return (T) car;
    }
}
