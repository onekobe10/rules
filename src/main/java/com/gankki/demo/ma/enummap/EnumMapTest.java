package com.gankki.demo.ma.enummap;

import java.util.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/1
 */
public class EnumMapTest {
	
	public static void main(String[] args){
		List<Clothes> clothes = Arrays.asList(new Clothes[]{
				new Clothes("C001",Size.SMALL),
				new Clothes("C002", Size.LARGE),
				new Clothes("C003", Size.LARGE),
				new Clothes("C004", Size.MEDIUM),
				new Clothes("C005", Size.SMALL),
				new Clothes("C006", Size.SMALL),
		});
		System.out.println(countBySize(clothes));

		Map<String, String> map = new HashMap<>();
		map.put("123", "123");
		Map<String, String> enumMap = new EnumMap(map);
	}

	public static Map<Size, Integer> countBySize(List<Clothes> clothes){
		Map<Size, Integer> map = new EnumMap<>(Size.class);
		for (Clothes c : clothes) {
			Size size = c.getSize();
			Integer count = map.get(size);
			if (count != null) {
				map.put(size, count + 1);
			} else {
				map.put(size, 1);
			}
		}
		return map;
	}
}
