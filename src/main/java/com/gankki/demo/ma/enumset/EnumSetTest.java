package com.gankki.demo.ma.enumset;

import java.util.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/2
 */
public class EnumSetTest {

	public static void main(String[] args){
		Set<Day> weekend = EnumSet.noneOf(Day.class);
		weekend.add(Day.SATURDAY);
		weekend.add(Day.SUNDAY);
		System.out.println(weekend);

		Worker[] workers = new Worker[]{
				new Worker("张三", EnumSet.of(
						Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.FRIDAY)),
				new Worker("李四", EnumSet.of(
						Day.TUESDAY, Day.THURSDAY, Day.SATURDAY)),
				new Worker("王五", EnumSet.of(
						Day.TUESDAY, Day.THURSDAY)),
		};
		// 哪些天一个人都不会来？
		Set<Day> days = EnumSet.allOf(Day.class);
		for(Worker w : workers){
			days.removeAll(w.getAvailableDays());
		}
		System.out.println(days);

		// 有哪些天至少会有一个人来？
		Set<Day> days2 = EnumSet.noneOf(Day.class);
		for(Worker w : workers){
			days2.addAll(w.getAvailableDays());
		}
		System.out.println(days2);

		// 哪些人周一和周二都会来
		Set<Worker> availableWorkers = new HashSet<>();
		for(Worker w : workers){
			if(w.getAvailableDays().containsAll(
					EnumSet.of(Day.MONDAY,Day.TUESDAY))){
				availableWorkers.add(w);
			}
		}
		for(Worker w : availableWorkers){
			System.out.println(w.getName());
		}

		// 哪些天至少会有两个人来
		Map<Day, Integer> countMap = new EnumMap<>(Day.class);
		for(Worker w : workers){
			for(Day d : w.getAvailableDays()){
				Integer count = countMap.get(d);
				countMap.put(d, count == null ? 1 : count + 1);
			}
		}
		Set<Day> days3 = EnumSet.noneOf(Day.class);
		for(Map.Entry<Day, Integer> entry : countMap.entrySet()){
			if(entry.getValue()>=2){
				days3.add(entry.getKey());
			}
		}
		System.out.println(days3);
	}
}
