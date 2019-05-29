package com.gankki.demo.test.breakcontinue;

/**
 * @author liuhao
 * @desc
 * @createDate 2019/5/29
 */
public class BreakContinueTest {

	/**
	 * break 跳出当前循环，并结束此次循环
	 * continue 停止当前迭代，并回到此次循环的开始位置，继续下一次迭代
	 * break label 中断所有迭代，并回到label处，结束当前正在的所有循环（内外循环均终止）
	 * continue label 中断所有迭代，回到label处，从外循环重新开始下一次循环
	 *
	 *  goto java中的保留字，没有使用，c++中常用于跳出多重循环，java中可以用break和continue实现跳出多重循环
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		outer:
		for (; ; ) {
			inner:
			for (; i < 10; i++) {
				System.out.println("i = " + i);
				if (2 == i) {
					System.out.println("continue");
					//i++;
					continue;
				}
				if (3 == i) {
					System.out.println("break");
					i++;
					break;
				}
				if (7 == i) {
					System.out.println("continue inner");
					i++;
					continue outer;
				}
				if (8 == i) {
					System.out.println("break outer");
					break outer;
				}
			}
		}

	}
}
