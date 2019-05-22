package com.gankki.demo.io.scnner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class ScnnerTest {

	public static List<Student> readStudents() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader("E:/gankkscode/gankkidir/hello4.txt"));
		try{
			List<Student> students = new ArrayList<Student>();
			String line = reader.readLine();
			while(line!=null){
				Student s = new Student();
				Scanner scanner = new Scanner(line).useDelimiter(",");
				s.setName(scanner.next());
				s.setAge(scanner.nextInt());
				s.setScore(scanner.nextDouble());
				students.add(s);
				line = reader.readLine();
			}
			return students;
		}finally{
			reader.close();
		}
	}

	public static void main(String[] args) throws IOException{
		readStudents();
	}
}
