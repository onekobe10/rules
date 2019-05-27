package com.gankki.demo.algorithm.sort.bubble;

import java.util.Arrays;

/**
 *@desc 冒泡排序
 *@author liuhao
 *@createDate 2019/5/27
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr){
		int arrLen = arr.length;
		// 外层循环依次移动游标
		for (int i = 0; i < arrLen; i++) {
			// 内层循环依次对比相邻元素大小
			for(int j = 0; j < arrLen - i - 1 ; j++){
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}


	public static void main(String[] args){
	    int[] arr = {10,9,8,7,6,5,4,3,2,1};
	    BubbleSort.bubbleSort(arr);
	}
}
