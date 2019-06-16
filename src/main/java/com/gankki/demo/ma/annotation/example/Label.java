package com.gankki.demo.ma.annotation.example;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/16
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface Label {
	String value() default "";
}
