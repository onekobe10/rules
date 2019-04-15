package com.gankki.demo.note150.overried;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author liuhao
 * @desc 方法的重写
 * @createDate 2018/10/16
 */
public class OverrideTest {

    protected void testOverride(String str) throws Exception {
        System.out.println("父类方法");
    }


    public static void main(String[] args) {
        /*
         * 1. 相同的形参
         * 2. 相同的返回类型
         * 3. 更大的访问权限，不能重写私有的方法，其他访问权限可以放大
         *    私有的方法在子类中也有但是不可见
         * 4. 抛出的异常只能更小
         * */
    }

}

class OverrideSonTest extends OverrideTest {


    @Override
    public void testOverride(String str) throws IOException, FileNotFoundException {
        System.out.println("子类重写父类的方法");
    }
}
