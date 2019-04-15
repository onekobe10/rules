package com.gankki.demo.note150.clone;

import java.io.Serializable;

public class CarTest implements Serializable, Cloneable {

    private static final long serialVersionUID = -9203482508786274888L;
    private String carName;
    private String carColor;
    private CircleTest circleTest;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public CircleTest getCircleTest() {
        return circleTest;
    }

    public void setCircleTest(CircleTest circleTest) {
        this.circleTest = circleTest;
    }
    /*@Override
    public Object clone(){
        CarTest carTest = null;
        try {
            carTest = (CarTest) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carTest;
    }*/

}
