package com.gankki.demo.ma;

import java.nio.charset.Charset;

public class StringTest {


	public static void main(String[] args) throws Exception{
		String str = "0123456789abcDMN0";
		System.out.println(str.substring(1));
		// subString 左闭区间 右开区间
		System.out.println(str.substring(0,3));
		// target在str中从头第一个匹配到的位置，如果匹配不到返回为-1
		System.out.println(str.indexOf("8"));
		System.out.println(str.indexOf("89"));
		// target在str中从尾第一个匹配到的位置，如果匹配不到返回为-1
		System.out.println(str.lastIndexOf("8"));
		System.out.println(str.lastIndexOf("89"));
		// 是否包含target字符序列
		System.out.println(str.contains("1"));
		System.out.println(str.contains("s"));
		// 是否以目标字符串结尾
		System.out.println(str.endsWith("789"));
		System.out.println(str.endsWith("9"));
		System.out.println(str.endsWith("987"));

		System.out.println(str.equalsIgnoreCase("123"));

		System.out.println(str.compareTo("01234"));
		System.out.println(str.compareTo("9"));
		System.out.println(str.compareToIgnoreCase("9"));

		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());

		// 删除开头和结尾的空格
		System.out.println(str.trim());

		// 字符串连接，返回当前字符串和参数字符串合并后的字符串，原字符串不变
		System.out.println(str.concat("   ss"));

		// 字符串替换，替换单个字符，返回新字符串，原字符串不变
		System.out.println(str.replace("0123", "s"));
		// 所有相同的字符全部替换
		System.out.println(str.replace("0", "H"));
		System.out.println(str.replaceAll("0", "H"));

		char[] b ={'1','2','3'};
		System.out.println(new String(b));

		System.out.println(str.charAt(0));

		// 使用System.arraycopy()返回内部字符序列的copy，不能直接返回（直接返回使得变量获得了str的引用）
		System.out.println(str.toCharArray());

		char[] d ={'s','m','t','b'};
		// 将str中从srcBegin开始到srcEnd结束位置的字符传覆盖到d从dstBegin开始的位置
		// 而且srcEnd - srcBegin的length不能大于从dstBegin开始d剩下的length
		str.getChars(1,4, d,1);
		System.out.println(d);
		System.out.println(str);
		
		System.out.println("----------------------------------------------------");
		
		// Returns the character (Unicode code point) at the specified
		System.out.println(str.codePointAt(0));
		// 指定索引之前位置的the character
		System.out.println(str.codePointBefore(1));
		// 区间内the character‘s total count
		System.out.println(str.codePointCount(0, 3));
		System.out.println(str.offsetByCodePoints(1,3));

		// String内部是按UTF-16BE处理字符的，对BMP字符，使用一个char，两个字节，对于增补字符，使用两个char，四个字节。
		// 除了通过String中的方法进行编码转换，Charset类中也有一些方法进行编码/解码
		// 重要的是认识到，Java的内部表示与各种编码是不同的，但可以相互转换。
		System.out.println(Charset.defaultCharset().name());

		Charset charset = Charset.forName("GB18030");

		System.out.println(charset.name());

		System.out.println(str.getBytes("UTF-8"));

		// 与包装类类似，String类也是不可变类，即对象一旦创建，就没有办法修改了。String类也声明为了final，不能被继承，内部char数组value也是final的，初始化后就不能再变了。
		// String类中提供了很多看似修改的方法，其实是通过创建新的String对象来实现的，原来的String对象不会被修改。
		// System.arraycopy()返回值为空，需要提前创建好对象才能copy
		// Arrays.copyOf() 返回的是copy之后的结果，放入的是要拷贝的对象

		String laoma = new String(new char[]{'老','马','说','编','程'});
		String name1 = new String(laoma);
		String name2 = new String(laoma);
		System.out.println(name1==name2);
		System.out.println(laoma.hashCode());
		System.out.println(name1.hashCode());
		System.out.println(name2.hashCode());

		// 通过正则表达式的方式判断target是否匹配
		System.out.println("123".matches("123"));

		String str3 = "123";
		System.out.println(str3.contentEquals("123"));

		System.out.println(String.format("%.2f", 10.1258));

		// 常量池类似一个JAVA系统级别提供的缓存
		// 直接使用双引号声明出来的String对象会直接存储在常量池中。
		// 如果不是用双引号声明的String对象，可以使用String提供的intern方法。
		// intern方法会从字符串常量池中查询当前字符串是否存在，若不存在就会将当前字符串放入常量池中
		System.out.println(new String("213").intern());

	}
}
