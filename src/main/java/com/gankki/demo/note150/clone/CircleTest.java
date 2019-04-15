package com.gankki.demo.note150.clone;

import java.io.Serializable;

public class CircleTest implements Serializable,Cloneable {
    private static final long serialVersionUID = -3426501265285817711L;
    private String circleName;

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }
}
