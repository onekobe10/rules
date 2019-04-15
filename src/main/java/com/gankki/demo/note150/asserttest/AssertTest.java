package com.gankki.demo.note150.asserttest;

/**
 * @author liuhao
 * @desc 断言测试
 * @createDate 2018/10/30
 */
public class AssertTest {


    public static void main(String[] args) {
        /*
         * 断言 assert
         * 默认是关闭的，需要vm中配置才能开启
         * -ea 是开启断言 -enableassertions -da 是关闭断言 -disableassertions
         * 参数必须为true或者false，为true时会抛出AssertionError的Error
         * */
        String test = "123";
        // 第一种格式
        assert ("123".equals(test));
        // 第二种格式，会将分号后面的信息在Error中打印
        assert ("1234".equals(test)) : "断言报错了";
        System.out.println("1........");
    }
}
