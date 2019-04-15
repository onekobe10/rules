package com.gankki.demo.ma.Java8Test;

import java.io.File;
import java.io.FilenameFilter;

public class Java7Test {

	public static void main(String[] args){

		String msg = "Hello World";
		//列出当前目录下的所有后缀为.txt的文件
		File f = new File("d:\\");
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
	}
}
