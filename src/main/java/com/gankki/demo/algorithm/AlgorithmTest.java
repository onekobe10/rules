package com.gankki.demo.algorithm;

/**
 * 算法测试
 *
 * @author liuhao
 * @date 2020/8/12
 */
public class AlgorithmTest {

    public static void main(String[] args) {
        // 1. ++i, i++ 的区别 ++i：先+1再参与计算，i++：先参与计算再+1。区别：i最后都会+1.只是在参与当前运算之前还是之后+1
        int i = 0, j = 0, x = 0, y = 0, t = 0;
        //x = ++i + j;
        x++;
        ++i;
        System.out.println(x);
        System.out.println(i);

        System.out.println("-------");
        // y = t++ + j;

        System.out.println(y);
        System.out.println(t);

        // 2. Java 中数组的三种创建赋值方式
        int[] arrI = {1, 2, 3};
        int[] arrX = new int[]{1, 2, 3};
        int[] arrJ = new int[3];
        arrJ[0] = 1;
        arrJ[1] = 2;
        arrJ[2] = 3;

        String s = "123";
        s.char
    }

}
