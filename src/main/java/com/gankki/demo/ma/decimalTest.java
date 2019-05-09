package com.gankki.demo.ma;

import java.math.BigDecimal;

/**
 *@desc 小数为什么会运算出错？
 *@author liuhao
 *@createDate 2019/5/9
 */
public class decimalTest {

	/**
	 * 出错的原因是计算机不能精确的表示很多数，数据表示都不准确，所以计算出错就不足为奇了。
	 * 比如0.1这个数，是十进制的表示方式
	 * 计算机中数据是用二进制表示的，0.1用二进制不能精确地表示，只能表示一个非常接近但又不等于0.1的数，
	 * 就像十进制中不能精确的表示1/3，只能表示为0.33333一样
	 * 二级制只能表示为2的多少次方和的数：
	 * 	2^(-1) = 0.5
	 * 	2^(-2) = 0.25
	 * 	2^(-3) = 0.125
	 * 	2^(-4) = 0.0625
	 *
	 *	如果真的需要比较高的精度，一种方法是将小数转化为整数进行运算，运算结束后再转化为小数，
	 *	另外的方法一般是使用十进制的数据类型，这个没有统一的规范，
	 *	在Java中是BigDecimal，运算更准确，但效率比较低
	 * @param args
	 */
	public static void main(String[] args){
		float f = 0.1f * 0.1f;
		System.out.println(f);

		/**
		 * BigDecimal只是提高了计算的精度，但是并不能得出0.01 * 0.01 = 0.0001，因为本来就不能精确的表示0.01
		 */
		BigDecimal b1 = new BigDecimal(0.01);
		BigDecimal b2 = new BigDecimal(0.01);
		System.out.println(b1.multiply(b2));
		/**
		 * 其实，这只是Java语言给我们造成的假象，计算结果其实也是不精确的，
		 * 但是由于结果和0.2足够接近，在输出的时候，Java选择了输出0.2这个看上去非常精简的数字，而不是一个中间有很多0的小数。
		 *
		 * 在误差足够小的时候，结果看上去是精确的，但不精确其实才是常态。
		 */
		System.out.println(0.1 + 0.1);

		/**
		 * 小数在java中叫浮点数，用float/double 单精度浮点数/双精度浮点数表示，32位/64位
		 * 小数默认为double类型，如果表示float类型需要加f/F
		 *
		 *  下面这些方法可以输出浮点数的二进制表示形式
		 */
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(0.1f)));
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(-0.1f)));

		System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.1)));
		System.out.println(Long.toBinaryString(Double.doubleToLongBits(0.1)));
	}
}
