package com.gankki.demo.test.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/30
 */
public class maptest {

	public static void main(String[] args){
		List<StreamBean> streamBeanList = new ArrayList<>();
		StreamBean s1 = new StreamBean("liuhao1", 25);
		StreamBean s2 = new StreamBean("liuhao2", 26);
		StreamBean s3 = new StreamBean("liuhao3", 27);
		streamBeanList.add(s1);
		streamBeanList.add(s2);
		streamBeanList.add(s3);
		Map<String, Integer> streamMap = streamBeanList.stream().collect(Collectors.toMap(StreamBean::getUserName, StreamBean::getAge));
		Iterator<Map.Entry<String, Integer>> iterator = streamMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println(entry.getKey() + "...map..." + entry.getValue());
		}

	}

}
