package com.gankki.demo.optimization.design.context.context;

import java.util.stream.IntStream;

/**
 * ThreadLocal 实现的线程上下文
 * ThreadLocal 中有三个常用的方法：set、get、initialValue
 * @author liuhao
 * @date 2020/3/21
 */

public class ContextTest2 {
    // 上下文类
    public static class Context {
        private String name;
        private long id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // 复制上下文到ThreadLocal中
    public final static class ActionContext {

        private static final ThreadLocal<Context> threadLocal = ThreadLocal.withInitial(() -> new Context());

        public static ActionContext getActionContext() {
            return ContextHolder.actionContext;
        }

        public Context getContext() {
            return threadLocal.get();
        }

        // 获取ActionContext单例
        public static class ContextHolder {
            private final static ActionContext actionContext = new ActionContext();
        }
    }

    // 设置上下文名字
    public class QueryNameAction {
        public void execute() {
            try {
                Thread.sleep(1000L);
                String name = Thread.currentThread().getName();
                ActionContext.getActionContext().getContext().setName(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 设置上下文ID
    public class QueryIdAction {
        public void execute() {
            try {
                Thread.sleep(1000L);
                long id = Thread.currentThread().getId();
                ActionContext.getActionContext().getContext().setId(id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 执行方法
    public class ExecutionTask implements Runnable {
        private QueryNameAction queryNameAction = new QueryNameAction();
        private QueryIdAction queryIdAction = new QueryIdAction();

        @Override
        public void run() {
            queryNameAction.execute();//设置线程名
            System.out.println("The name query successful");
            queryIdAction.execute();//设置线程ID
            System.out.println("The id query successful");

            System.out.println("The Name is " + ActionContext.getActionContext().getContext().getName() + " and id " + ActionContext.getActionContext().getContext().getId());
        }
    }

    public static void main(String[] args) {
        IntStream.range(1, 5).forEach(i -> new Thread(new ContextTest2().new ExecutionTask()).start());
    }
}
