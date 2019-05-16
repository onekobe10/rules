package com.gankki.demo.designpattern.principle.lsp.session4;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Son extends Father {

	public Collection doSomething(Map map){
		System.out.println("子类被执行。。。");
		return map.values();
	}

	public List doSomething3(HashMap map) throws Exception{
		System.out.println("父类被执行...");
		return null;

	}
}
