package com.gankki.demo.designpattern.principle.lsp.session4;

import java.util.Collection;
import java.util.HashMap;

public class Father {
	
	public Collection doSomething(HashMap map) throws Exception{
		System.out.println("父类被执行...");
		return map.values();
		
	}

	public Collection doSomething2(HashMap map) throws Exception{
		System.out.println("父类被执行...");
		return map.values();

	}
}
