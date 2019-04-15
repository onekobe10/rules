package com.gankki.demo.ma;

public class CharacterTest {

	public static void main(String[] args){
		// 判断一个int是不是一个有效的代码单元(Unicode code point)
		System.out.println(Character.isValidCodePoint(0));
		// 判断一个int是不是BMP字符
		System.out.println(Character.isBmpCodePoint(48));
		// 判断一个int是不是增补字符
		System.out.println(Character.isSupplementaryCodePoint(48));
		// 判断char是否是高代理项
		System.out.println(Character.isHighSurrogate('1'));
		// 判断char是否为低代理项
		System.out.println(Character.isLowSurrogate('1'));
		// 判断char是否为代理项
		System.out.println(Character.isSurrogate('1'));
		// 判断两个字符high和low是否分别为高代理项和低代理项
		System.out.println(Character.isSurrogatePair('1', '2'));
		// 判断一个代码单元由几个char组成
		System.out.println(Character.charCount(1358));

		System.out.println("----------------------------");

		// 根据高代理项high和低代理项low生成代码单元
		System.out.println(Character.toCodePoint('1', '2'));
		// 根据代码单元生成char数组，即UTF-16表示
		System.out.println(Character.toChars(1024));
		// 对增补字符code point，生成高代理项和低代理项
		System.out.println(Character.lowSurrogate(1024));
		// 获取字符类型(general category)
		System.out.println(Character.getType('A'));
		System.out.println(Character.getType(48));
		// 检查字符是否在Unicode中被定义
		System.out.println(Character.isDefined(48));
		// 检查字符是否为数字
		char ch = '９';
		System.out.println((int)ch+","+Character.isDigit(ch));
	}
}
