package com.gankki.demo.note150.innerClass;

class Outer {

    public static void foo() { new Outer(). new Inner().testInnerClass(); }

    public void bar() { new Inner(); }

    static class StaticClass{
        public void testStaticClass(){
            System.out.println("静态内部类方法");
        }
        public static  void testStaticClass2(){
            System.out.println("静态内部类的静态方法");
        }
    }

    class Inner {
        public void testInnerClass(){
            System.out.println("内部类测试");
        }
        /*public static void testInnerClass2(){
            System.out.println("内部类测试");
        }*/
    }

    public static void main(String[] args) {
        Outer.foo();
        Outer.StaticClass staticClass2 = new Outer.StaticClass();
        StaticClass staticClass = new StaticClass();
        staticClass.testStaticClass();
        Outer.StaticClass.testStaticClass2();

        /*
        * 内部类的访问前提是透过外部类访问,并且内部类不能有静态方法，实例化需要先实例化外部类
        * 静态内部类可以直接访问，也可以有静态方法，静态内部类只是可以不经过外部类访问而已，并不是它内部的方法都是静态方法
        * 静态内部类的普通方法，需要通过new静态内部类的方法来访问   实例化不需要经过外部类
        *
        * */

    }


}