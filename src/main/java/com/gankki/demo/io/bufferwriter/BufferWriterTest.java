package com.gankki.demo.io.bufferwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/22
 */
public class BufferWriterTest {

	public static void writeStudents(List<Student> students) throws IOException {
		BufferedWriter writer = null;
		try{
			writer = new BufferedWriter(new FileWriter("E:/gankkscode/gankkidir/hello3.txt"));
			for(Student s : students){
				writer.write(s.getName()+","+s.getAge()+","+s.getScore());
				writer.newLine();
			}
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
	}

	public static List<Student> readStudents() throws IOException{
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(
					new FileReader("E:/gankkscode/gankkidir/hello3.txt"));
			List<Student> students = new ArrayList<>();
			String line = reader.readLine();
			while(line!=null){
				String[] fields = line.split(",");
				Student s = new Student();
				s.setName(fields[0]);
				s.setAge(Integer.parseInt(fields[1]));
				s.setScore(Double.parseDouble(fields[2]));
				students.add(s);
				line = reader.readLine();
			}
			return students;
		}finally{
			if(reader!=null){
				reader.close();
			}
		}
	}


	public static void main(String[] args) throws Exception{
		List<Student> students = Arrays.asList(new Student[]{
				new Student("张三", 18, 80.9d),
				new Student("李四", 17, 67.5d)
		});

		writeStudents(students);

		readStudents();
	}
}
