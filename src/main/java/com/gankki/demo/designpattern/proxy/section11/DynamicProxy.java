package com.gankki.demo.designpattern.proxy.section11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/20
 */
public class DynamicProxy<T> {

	public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
		T newProxyInstance = (T)Proxy.newProxyInstance(loader,interfaces, h);
		return newProxyInstance;
	}
}
