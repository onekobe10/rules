package com.gankki.demo.optimization.design.future;


public class App {

    public static void main(String[] args) {

        TaskServiceImpl<String, String> taskService = new TaskServiceImpl<>();//创建任务提交类
        MakeCarTask<String, String> task = new MakeCarTask<>();//创建任务

        Future<?> future = taskService.submit(task, "car1");//提交任务
        String result = (String) future.get();//获取结果

        System.out.print(result);
    }

}
