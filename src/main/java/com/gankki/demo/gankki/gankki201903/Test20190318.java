package com.gankki.demo.gankki.gankki201903;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test20190318 {
	
	
	public static void main(String[] args){
		Map<String,String> map1 = new HashMap<String,String>();
		Map<String,String> map2 = new HashMap<String,String>();
		Map<String,String> map3 = new HashMap<String,String>();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		map1.put("name","小明");
		map1.put("age","23");
		map1.put("sex","男");
		list.add(map1);

		map2.put("name","小王");
		map2.put("age","24");
		map2.put("sex","女");
		list.add(map2);

		map3.put("name","小张");
		map3.put("age","22");
		map3.put("sex","男");
		list.add(map3);

		String jsonStr = JSON.toJSONString(list);
		System.out.println(jsonStr);

		List<HashMap<String, String>> listMap = new ArrayList<HashMap<String, String>>();

		listMap = JSON.parseObject(jsonStr, List.class);
		System.out.println(JSON.toJSONString(listMap));
	}
}
