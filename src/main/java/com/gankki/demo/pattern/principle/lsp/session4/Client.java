package com.gankki.demo.pattern.principle.lsp.session4;

import java.util.HashMap;
import java.util.Map;

public class Client {
	public static void invoker() throws  Exception{
		//父类存在的地方，子类就应该能够存在
		//Father f = new Father();
		Son f = new Son();
		HashMap map = new HashMap();
		f.doSomething(map);
	}
	
	public static void main(String[] args) throws Exception {
		invoker();
	}
}
