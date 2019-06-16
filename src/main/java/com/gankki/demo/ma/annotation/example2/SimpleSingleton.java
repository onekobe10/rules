package com.gankki.demo.ma.annotation.example2;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface SimpleSingleton {
}
