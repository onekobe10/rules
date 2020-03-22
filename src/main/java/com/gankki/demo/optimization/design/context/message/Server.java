package com.gankki.demo.optimization.design.context.message;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 针对每一个 Socket 连接创建一个相应的线程处理。
 * 如果针对每个 I/O 请求都创建一个线程来处理，在有大量请求同时进来时，就会创建大量线程，而此时 JVM 有可能会因为无法处理这么多线程，而出现内存溢出的问题。
 * 退一步讲，即使是不会有大量线程的场景，每次请求过来也都需要创建和销毁线程，这对系统来说，也是一笔不小的性能开销。
 * 面对这种情况，我们可以使用线程池来代替线程的创建和销毁，这样就可以避免创建大量线程而带来的性能问题，是一种很好的调优方法。
 */
public class Server {

    private static int DEFAULT_PORT = 12345;
    private static ServerSocket server;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    public static void start(int port) throws IOException {
        if (server != null) {
            return;
        }

        try {
            //启动服务
            server = new ServerSocket(port);
            // 通过无线循环监听客户端连接
            while (true) {
                Socket socket = server.accept();
                // 当有新的客户端接入时，会执行下面的代码
                long start = System.currentTimeMillis();
                new Thread(new ServerHandler(socket)).start();

                long end = System.currentTimeMillis();

                System.out.println("Spend time is " + (end - start));
            }
        } finally {
            if (server != null) {
                System.out.println("服务器已关闭。");
                server.close();
            }

        }

    }

    public static void main(String[] args) {
        // 运行服务端
        new Thread(() -> {
            try {
                Server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
