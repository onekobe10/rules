package com.gankki.demo.portal.rules.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *@desc alibaba开发文档测试类
 *@author liuhao
 *@createDate 2018/9/17
 */
public class AlibabaTest {

	public String strArr1[]; // 不建议使用的声明方式

	public String[] strArr2;



	public static void main(String[] args) {
		/* 文件目录对象的测试

		FileOutputStream fos = null;
		try {
			String word = "我这是测试啊啊啊";
			File file = new File("d:/c/c.txt");
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			fos = new FileOutputStream(file);
			fos.write(word.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		*/

		/* 字符串分隔的测试

		String str = "a,b,c,,,d,,,,";
		String[] arrStr = str.split(",");
		System.out.println(arrStr.length+".....");// 3
        for (String str1 : arrStr) {// 每一个逗号都会分隔，分隔内容为空的不会统计
            System.out.println(str1+"..."+str1.length()+"..."+str1.equals("")); // a b c
        }

        */


		/* 测试缓存的整型数据

		Float m = 11F;
        Float n = 11F;
        System.out.println(m == n); //false
        Double c = 111d;
        Double d = 111d;
        System.out.println(c == d); // false
        Byte k = 11;
        Byte g = 11;
        System.out.println(k == g); // true
        Short t = 12;
        Short s = 12;
        System.out.println(t == s); // true
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); // false
        Long e = 1112L;
        Long f = 1112L;
        System.out.println(e == f); // false
        Long o = 111L;
        Long q = 111L;
        System.out.println(o == q); // true

        */

        /* list转数组方式
           subList返回的是原list的视图，subList对象的修改会直接造成原对象的修改

        List<String> list = new ArrayList<>(2);
        list.add("sss");
        list.add("aaa");
        list.add("bbb");

        System.out.println(list.subList(0, 1).remove("sss"));

        String[] arr = new String[list.size()];
        list.toArray(arr);
        System.out.println(arr.length + "..." + arr[0] +"..." + arr[1]);// 2...aaa...bbb

		String[] testArr = new String[] {"aaa", "bbb", "ccc"};
		List<String> arrToList = Arrays.asList(testArr);
		// java.lang.UnsupportedOperationException
		// arrToList.add("eee"); asList方法体现的是适配器的设计模式（只是转换接口，后台的数据还是数组），
		// 转换的是一个Arrays内部的一个实现了List接口的内部类
		// 但是这个内部类么有实现add、remove、clear等方法。
		System.out.println(arrToList.toString());
		testArr[0] = "test";
		System.out.println(arrToList.toString()); // [test, bbb, ccc]

		*/

        /* 推荐使用Iterator遍历删除元素，使用foreach删除会出问题 继续测试*
		 */
        List<String> list = new ArrayList<>(5);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("eee");
        list.add("fff");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if ("aaa".equals(next)) {
				iterator.remove();
			}
		}
		System.out.println(list.toString());
		for (String str : list) {
			System.out.println(str + "...");
			list.remove(str);
			if ("aaa".equals(str)) {
				list.remove("aaa");
			}
		}
		System.out.println(list.toString());



        /* map的遍历问题和lamda表达式
		Map<String, String> map = new HashMap<>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		Set<String> set = map.keySet(); //遍历两次
		for (String str : set) {
			System.out.println(str + ".....1....." + map.get(str));
		}

		Set<Map.Entry<String, String>> entrySet =  map.entrySet(); // 获取到entry对象之后，只遍历一次
		for (Map.Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + "....2...." + entry.getValue());
		}

		map.forEach((k, v) -> System.out.println("key : " + k + ".....3..lamda.. value: " + v));
		// jdk1.8之后推荐使用lamda表达式



        /* 使用Random对象代替Math.random()方法创建随机数

        Random randomFirst = new Random(1);
		Random randomSecond = new Random(1); //相同seed，相同的bound，产生的随机数是一致的
		Random randomBoolean = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.print(randomFirst.nextInt(100) + " ");
		}
		System.out.println("\n我是分隔线-------------");
		for (int i = 0; i < 10; i++) {
			System.out.print(randomSecond.nextInt(100) + " ");
		}
		System.out.println("\n我是分隔线-------------");

		for (int i = 0; i < 10; i++) {
			System.out.print(randomBoolean.nextBoolean() + " ");
		}

		*/

        /* switch byte shot char int 枚举 jdk1.7新增 String 没有break/return case穿透

		String switchStr = "test";
		switch (switchStr) {
			case "aaa" :
				System.out.println("aaa");
				break;
			case "bbb" :
				System.out.println("bbb");
				break;
			case "ccc" :
				System.out.println("ccc");
				break;
			default:
				System.out.println("default");
		}
		byte switchByte = 1;
		switch (switchByte) {
			case 1 :
				System.out.println("byte...........1");
				break;
			case 2 :
				System.out.println("byte...........2");
				break;
			case 3 :
				System.out.println("byte...........3");
				break;
			default:
				System.out.println("default.......... ");

		}

		*/


	}
}
