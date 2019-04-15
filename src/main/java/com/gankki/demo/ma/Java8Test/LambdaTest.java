package com.gankki.demo.ma.Java8Test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/3/24
 */
public class LambdaTest {

	public static void main(String[] args){
		File file = new File(".");
		// Lamdba表达式 第一种写法
		File[] files =file.listFiles((File dir, String name) -> {
			return name.endsWith(".txt");
		});
		// 之所以可以省略方法的参数类型，是因为Java可以自动推断出来，它知道listFiles接受的参数类型是FilenameFilter，
		// 这个接口只有一个方法accept，这个方法的两个参数类型分别是File和String。
		file.listFiles((dir, name) -> {
			return name.endsWith(".txt");
		});
		// 方法中只有一条语句时可以省略大括号
		file.listFiles((File dir, String name) -> name.endsWith(".txt"));
		// 可以继续省略形参的类型声明
		file.listFiles((dir, name) -> name.endsWith(".txt"));

		System.out.println("------------我是分割线---------------------------");

		Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
		Arrays.sort(files, Comparator.comparing(File::getName));

		File[] files1 = file.listFiles(pathname -> pathname.getName().endsWith(".txt"));

		ExecutorService executor = Executors.newFixedThreadPool(100);
		executor.submit(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world");
			}
		});

		String msg = "Hello World";
		executor.submit(() -> System.out.println("hello world"));
		executor.submit(() -> System.out.println("hello world," + msg));

		//列出当前目录下的所有后缀为.txt的文件
		File f = new File(".");
		File[] files3 = f.listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".txt")){
					System.out.println(msg);
					return true;
				}
				return false;
			}
		});

		Arrays.sort(files, new Comparator<File>() {

			@Override
			public int compare(File f1, File f2) {
				return f1.getName().compareTo(f2.getName());
			}

			@Override
			public boolean equals(Object obj){
				return true;
			}
		});

	}
}
