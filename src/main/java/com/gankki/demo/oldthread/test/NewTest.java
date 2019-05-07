package com.gankki.demo.oldthread.test;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/7
 */
public class NewTest {


	public static void main(String[] args){
	    Thread t = new Thread();
	    t.run();
	    System.out.println(t.getName());
	}
}
