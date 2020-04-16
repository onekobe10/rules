package com.gankki.demo.gankki.tryresource;

import java.io.*;

/**
 * 
 * @author liuhao
 * @date 2020/4/17 
 */
public class TryResourceTest {

    /**
     * JDK 1.7 引入 try-with-resources 声明要求其中定义的变量实现 AutoCloseable 接口，
     * 这样系统可以自动调用它们的close方法，从而替代了finally中关闭资源的功能。
     *
     * try-with-resources将会自动关闭try()中的资源，并且将先关闭后声明的资源。
     *
     * try-with-resources 其实是个语法糖，它将在编译时生成关闭资源的代码。
     */

    // try-with-resource 实现
    public static void copy1(String src, String dst) {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 一个简单的复制文件方法。
    public static void copy2(String src, String dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst);
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
