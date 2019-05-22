package com.gankki.demo.io.printwriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class PrintWriterTest {

	public static void writeStudents(List<Student> students) throws IOException {
		PrintWriter writer = new PrintWriter("E:/gankkscode/gankkidir/hello4.txt");
		try{
			for(Student s : students){
				writer.println(s.getName()+","+s.getAge()+","+s.getScore());
			}
		}finally{
			writer.close();
		}
	}

	public static void main(String[] args) throws Exception{
		List<Student> students = Arrays.asList(new Student[]{
				new Student("张三", 18, 80.9d),
				new Student("李四", 17, 67.5d)
		});
		writeStudents(students);
	}
}
