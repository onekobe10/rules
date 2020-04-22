package com.gankki.demo.gankki.finallytest;

/**
 * finally test
 *
 * @author liuhao
 * @date 2020/4/18
 */
public class FinallyTest {


    public static void main(String[] args){
        System.out.println(test2());

        System.out.println("=========================");

        test1();
    }

    /**
     * 如果 finally中有返回值优先级大于正常执行逻辑返回值和异常返回值，会覆盖它们的返回值，不利于代码可读性
     * 建议不要在 finally 中使用返回值
     * @return
     */
    public static String test2() {
        try {
            System.out.println("1");
            throw new NullPointerException();
        } catch (Exception e) {
            return "catch2";
        } finally {
            System.out.println("finally");
            return "catch3";
        }
    }

    /**
     * 特殊情况 System.exit()，程序退出时不会执行finally中方法
     */
    public static void test1() {
        try {
            System.out.println("1");
            System.exit(1);
        } finally {
            System.out.println("Print from finally");
        }
    }
}
