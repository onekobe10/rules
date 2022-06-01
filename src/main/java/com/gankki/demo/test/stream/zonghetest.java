package com.gankki.demo.test.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/30
 */
public class zonghetest {

	public static void main(String[] args){
		List<StreamBean> streamBeanList = new ArrayList<>();
		StreamBean s1 = new StreamBean("liuhao1", 25);
		StreamBean s2 = new StreamBean("liuhao2", 26);
		StreamBean s3 = new StreamBean("liuhao3", 27);
		streamBeanList.add(s1);
		streamBeanList.add(s2);
		streamBeanList.add(s3);

		Map<String, Integer> streamMap1 = streamBeanList.stream().
				collect(Collectors.toMap(StreamBean::getUserName, StreamBean::getAge));
		System.out.println(streamMap1.size());

		Map<String, Integer> streamMap2 = streamBeanList.stream().
				filter(streamBean -> streamBean.getAge() / 2 != 0).
				collect(Collectors.toMap(StreamBean::getUserName, StreamBean::getAge));
		System.out.println(streamMap2.size());

		List<SingleFieldStream> singleFieldStreamList =  streamBeanList.stream().
				filter(streamBean -> streamBean.getAge() % 2 != 0).
				map(streamBean -> new SingleFieldStream(streamBean.getUserName())).
				collect(Collectors.toList());
		System.out.println(singleFieldStreamList.size());

		List<SingleFieldStream> singleFieldStreamList2 =  streamBeanList.stream().
				filter(streamBean -> Objects.equals("liuhao2", streamBean.getUserName())).
				map(streamBean -> new SingleFieldStream(streamBean.getUserName())).
				collect(Collectors.toList());
		System.out.println(singleFieldStreamList2.size());
	}

}
