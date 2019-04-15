package com.gankki.demo.note150.abstractAndInterface;

public class AbstractClassTest2 extends AbstractClassTest {
    public AbstractClassTest2() {
        super();
    }

    @Override
    public void testBeforeMethod() {
        System.out.println("实现类测试");
    }



    public static void main(String[] args){
        AbstractClassTest2 abs = new AbstractClassTest2();
        abs.testMethd();
		InterfaceTest.testStaticMethod();
    }
}
