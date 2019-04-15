package com.gankki.demo.note150.clone;

import java.io.Serializable;

public class CloneTest implements Serializable,Cloneable{


    private static final long serialVersionUID = 6671671739765855426L;
    private String userName;
    private String userSex;
    private CarTest carTest;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public CarTest getCarTest() {
        return carTest;
    }

    public void setCarTest(CarTest carTest) {
        this.carTest = carTest;
    }

/*    @Override
    public Object clone(){
        CloneTest cloneTest = null;
        try {
            cloneTest = (CloneTest) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneTest;
    }*/


    public static void main(String[] args) throws  Exception{
        CarTest carTest = new CarTest();
        carTest.setCarName("Lexus");
        carTest.setCarColor("蓝色");
        CircleTest circleTest = new CircleTest();
        circleTest.setCircleName("黑轮子");
        carTest.setCircleTest(circleTest);
        CloneTest cloneTest = new CloneTest();
        cloneTest.setUserName("刘浩");
        cloneTest.setUserSex("男");
        cloneTest.setCarTest(carTest);

        //CloneTest test = MyCloneUtil.clone(cloneTest);
        //System.out.println(test.getUserName() + "......" + test.getUserSex());

        CloneTest cloneTest1 = (CloneTest) cloneTest.clone();

        System.out.println("----------------------------------------------");
        System.out.println(cloneTest1.getUserName() + ".........." + cloneTest1.getCarTest().getCarName() + "....." + cloneTest1.getCarTest().getCircleTest().getCircleName());



        /*
        * java.lang.CloneNotSupportedException: com.boco.eoms.note150.clone.CloneTest 需要实现CloneAble接口
        *  刘浩..........null
        *
        * */
    }
}
