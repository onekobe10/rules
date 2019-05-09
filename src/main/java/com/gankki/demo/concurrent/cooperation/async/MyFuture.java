package com.gankki.demo.concurrent.cooperation.async;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public interface MyFuture<V> {
	V get() throws Exception ;
}
