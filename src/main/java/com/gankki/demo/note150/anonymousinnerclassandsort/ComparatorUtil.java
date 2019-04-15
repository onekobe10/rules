package com.gankki.demo.note150.anonymousinnerclassandsort;

import java.util.Comparator;

public class ComparatorUtil implements Comparator<Students1> {

    @Override
    public int compare(Students1 s1, Students1 s2) {
        return s1.getA() - s1.getA();
    }
}
