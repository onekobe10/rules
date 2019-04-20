package com.gankki.demo.ma;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuhao
 * @desc
 * @createDate 2019/4/18
 */
public class ArrayTest {

	public static void main(String[] args) {
		int[] arrs = new int[3];
		arrs[0]=1;
		System.out.println(arrs.length);
		System.out.println(arrs);

		Integer[] intArr = {1, 3, 21, 5, 8, 8};
		String[] strArr = {"a", "B", "A", "D", "E", "A"};
		System.out.println(intArr.length);

		// toString()
		System.out.println(intArr);
		System.out.println(Arrays.toString(intArr));

		// sort()
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));

		Arrays.sort(intArr, Comparator.reverseOrder());
		System.out.println(Arrays.toString(intArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(intArr));

		// binarySearch针对的必须是已排序数组，如果指定了Comparator，需要和排序时指定的Comparator保持一致
		// 另外，如果数组中有多个匹配的元素，则返回哪一个是不确定的。
		int[] intArr1 = {3,5,7,13,21};
		System.out.println(Arrays.binarySearch(intArr1, 13));

		String[] strArr1 = {"hello", "world"};
		String[] newArr = Arrays.copyOf(strArr1, 3);
		System.out.println(Arrays.toString(newArr));

		// 长度一致且每个位置的元素相等
		System.out.println(Arrays.equals(strArr, strArr1));

		System.out.println(Arrays.hashCode(strArr));

		// 多维数组
		int[][] arr = new int[][]{
				{0,1},
				{2,3,4},
				{5,6,7,8}
		};
		System.out.println(Arrays.deepToString(arr));
		System.out.println(Arrays.deepHashCode(arr));

	}
}
