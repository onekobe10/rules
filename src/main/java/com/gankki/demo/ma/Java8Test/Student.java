package com.gankki.demo.ma.Java8Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/3/30
 */
public class Student {
	String name;
	double score;

	public Student(String name, double score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public static String getCollegeName(){
		return "Laoma School";
	}

	public static void main(String[] args){
		List<Student> students = Arrays.asList(new Student[] {
				new Student("zhangsan", 89d),
				new Student("lissi", 189d),
				new Student("liasi", 29d),
				new Student("ligfsi", 19d),
				new Student("lidsi", 89d),
				new Student("wangwu", 98d) });

		// 过滤90分以上的
		List<Student> studentFilter = Student.filter(students, s -> s.getScore() > 90);

		Student t = new Student("张三", 89d);

		// 函数式数据处理
		List<Student> above90List = students.stream().filter(s -> s.getScore() > 90).collect(Collectors.toList());
		List<String> nameList = students.stream().map(Student::getName).collect(Collectors.toList());
		List<String> gt90NameList = students.stream().filter(s -> s.getScore() > 90).map(Student::getName).collect(Collectors.toList());

		List<String> list = Arrays.asList(new String[]{"abc","def","hello","Abc"});
		List<String> retList = list.stream()
				.filter(s -> s.length() <= 3)
				.map(String::toLowerCase)
				.distinct()
				.collect(Collectors.toList());
		System.out.println(retList);

		List<Student> lists = students.stream()
				.filter(s -> s.getScore() > 90)
				.sorted(Comparator.comparing(Student::getScore)
						.reversed()
						.thenComparing(Student::getName))
				.collect(Collectors.toList());

		List<Student> listSort = students.stream()
				.sorted(Comparator.comparing(
						Student::getScore).reversed())
				.skip(1)
				.limit(3)
				.collect(Collectors.toList());

		List<Student> listPeek = students.stream()
				.sorted(Comparator.comparing(
						Student::getScore).reversed())
				.skip(1)
				.limit(3)
				.peek(System.out::println)
				.collect(Collectors.toList());

		double sum = students.stream()
				.mapToDouble(Student::getScore)
				.sum();

		List<String> lines = Arrays.asList(new String[]{
				"hello abc",
				"老马  编程"
		});
		List<String> words = lines.stream()
				.flatMap(line -> Arrays.stream(line.split("\\s+")))
				.collect(Collectors.toList());
		System.out.println(words);
	}

	public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
		List<E> retList = new ArrayList<>();
		for (E e : list) {
			if (pred.test(e)) {
				retList.add(e);
			}
		}
		return retList;
	}
}
