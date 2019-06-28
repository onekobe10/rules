package com.gankki.demo.optimization.java.o4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@desc 正则表达式
 *@author liuhao
 *@createDate 2019/6/28
 */
public class Test1 {
	/**
	 *
	 * @param args
	 */
	public static void main( String[] args )
	{
	    // 捕获组是指把正则表达式中，子表达式匹配的内容保存到以数字编号或显式命名的数组中，方便后面引用。一般一个 () 就是一个捕获组，捕获组可以进行嵌套。
		String text = "<input high=\"20\" weight=\"70\">test</input>";
		String reg="(<input.*?>)(.*?)(</input>)";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		while(m.find()) {
			System.out.println(m.group(0));// 整个匹配到的内容
			System.out.println(m.group(1));//(<input.*?>)
			System.out.println(m.group(2));//(.*?)
			System.out.println(m.group(3));//(</input>)
		}

		System.out.println("--------------------************---------------");

		// 非捕获组则是指参与匹配却不进行分组编号的捕获组，其表达式一般由（?:exp）组成。
		String text1 = "<input high=\"20\" weight=\"70\">test</input>";
		String reg1 ="(?:<input.*?>)(.*?)(?:</input>)";
		Pattern p1 = Pattern.compile(reg1);
		Matcher m1 = p1.matcher(text1);
		while(m1.find()) {
			System.out.println(m1.group(0));// 整个匹配到的内容
			System.out.println(m1.group(1));//(.*?)
		}

		// 综上可知：减少不需要获取的分组，可以提高正则表达式的性能。

	}

}
