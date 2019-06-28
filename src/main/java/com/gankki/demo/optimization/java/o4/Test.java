package com.gankki.demo.optimization.java.o4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/28
 */
public class Test {


	public static void main(String[] args){
		// 贪婪模式 会发生回溯
		String text = "abbc";
		String reg = "ab{1,3}c";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		System.out.println(m.matches());

		// 懒惰模式
		String text1 = "abbbc";
		String reg1 = "ab{1,3}?bc";
		Pattern p1 = Pattern.compile(reg1);
		Matcher m1 = p1.matcher(text1);
		System.out.println(m1.matches());

		// 独占模式
		String text2 = "abbc";
		String reg2 = "ab{1,3}+bc";
		Pattern p2 = Pattern.compile(reg2);
		Matcher m2 = p2.matcher(text2);
		System.out.println(m2.matches()); // false
		/**
		 * 1、匹配regex中的a和text中的a，匹配成功，继续匹配下一个字符；
		 * 2、匹配regex中的b{1,3}+，这个时候是最大匹配规则，
		 * 也就是说text中会尽量多的去匹配b，直到满足3个b字符匹配成功，才会结束b{1,3}的匹配，这里可以直接匹配到text中的abb；
		 * 3、由于还没有满足最大3个的匹配需求，会继续匹配text中的c，发现不匹配，这个时候regex会跳到后面这个字符b，拿这个字符继续匹配；
		 * 4、regex中的b发现与text中的c不匹配，则不匹配 返回false
		 * 5. 如果是 "ab{1,3}+c"; 则 c 能匹配则返回 true
		 *
		 * 懒惰模式是每次拿最少，独占模式模式是每次拿做多元素比较比较
		 * 但并不是固定的，会根据实际情况回溯或获取下一个匹配元素匹配，并不是固定不变的。
		 * 具体情况具体分析，这两种模式减少了回溯的概率。
		 */

	}
}
