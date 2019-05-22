package com.gankki.demo.io.data;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@desc 以基本数据类型为单位读写
 *  但是其将各种数据类型以二进制形式输出，用户无法方便的进行查看。
 *  使用PrintWriter类的print()和PrintLn()方法可以轻松地实现将Java的各种数据类型转换为字符串类型输出。
 *  使用DataInputStream/DataOutputStream读写对象，非常灵活，但比较麻烦，所以Java提供了序列化机制
 *@author liuhao
 *@createDate 2019/5/22
 */
public class DataOutputStreamTest {

	public static void writeStudents(List<Student> students) throws IOException {
		DataOutputStream output = new DataOutputStream(
				new FileOutputStream("E:/gankkscode/gankkidir/hello1.dat"));
		try{
			output.writeInt(students.size());
			for(Student s : students){
				output.writeUTF(s.getName());
				output.writeInt(s.getAge());
				output.writeDouble(s.getScore());
			}
		}finally{
			output.close();
		}
	}

	public static List<Student> readStudents() throws IOException{
		DataInputStream input = new DataInputStream(
				new FileInputStream("E:/gankkscode/gankkidir/hello1.dat"));
		try{
			int size = input.readInt();
			List<Student> students = new ArrayList<>(size);
			for(int i=0; i<size; i++){
				Student s = new Student();
				s.setName(input.readUTF());
				s.setAge(input.readInt());
				s.setScore(input.readDouble());
				students.add(s);
			}
			return students;
		}finally{
			input.close();
		}
	}

	/**
	 * DataOutputStream是装饰类基类FilterOutputStream的子类，FilterOutputStream是OutputStream的子类
	 * 在写入时，DataOutputStream会将这些类型的数据转换为其对应的二进制字节，比如：
	 * 1. writeBoolean: 写入一个字节，如果值为true，则写入1，否则0
	 * 2. writeInt: 写入四个字节，最高位字节先写入，最低位最后写入
	 * 3. writeUTF: 将字符串的UTF-8编码字节写入，这个编码格式与标准的UTF-8编码略有不同，不过，我们不用关心这个细节。
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		List<Student> students = Arrays.asList(new Student[]{
				new Student("张三", 18, 80.9d),
				new Student("李四", 17, 67.5d)
		});

		writeStudents(students);

		readStudents();

		System.out.println(Charset.defaultCharset());
	}
}
