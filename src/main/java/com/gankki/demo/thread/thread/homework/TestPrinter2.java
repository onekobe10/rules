package com.gankki.demo.thread.thread.homework;

/**
 * 2. ��д�����߳�,һ���̴߳�ӡ1-52����������һ���̴߳�ӡ��ĸA-Z����ӡ˳��Ϊ12A34B56C��.5152Z����������������ĸ��˳���С�����ӡ��
 * ����ÿ��ӡ���������󣬴�ӡһ����ĸ������ѭ����ӡ��ֱ����ӡ������52����ĸZ������ Ҫ�� 1)
 * ��д��ӡ��Printer������˽������index����ʼֵΪ1��������ʾ�ǵڼ��δ�ӡ�� 2) �ڴ�ӡ��Printer�б�д��ӡ���ֵķ���print(int
 * i)��3�ı�����ʹ��wait()�����ȴ�����������i��ʹ��notifyAll()���л��������̡߳� 3)
 * �ڴ�ӡ��Printer�б�д��ӡ��ĸ�ķ���print(char
 * c)������3�ı����͵ȴ�������ʹ�ӡ�����ĸc��ʹ��notifyAll()���л��������̡߳� 4)
 * ��д��ӡ���ֵ��߳�NumberPrinter�̳�Thread�࣬����˽������private Printer
 * p;�ڹ��췽���н��и�ֵ��ʵ�ָ����run����������Printer���е�������ֵķ����� 5)
 * ��д��ӡ��ĸ���߳�LetterPrinter�̳�Thread�࣬����˽������private Printer
 * p;�ڹ��췽���н��и�ֵ��ʵ�ָ����run����������Printer���е������ĸ�ķ����� 6)
 * ��д������Test��������ӡ����󣬴��������߳�����������̡߳�
 * 
 * @author Gankki
 *
 * 
 */
public class TestPrinter2 {
	public static void main(String[] args) {
		Printer p = new Printer();
		NumberPrinter2 np = new NumberPrinter2(p);
		LetterPrinter2 lp = new LetterPrinter2(p);

		lp.start();
		np.start();
		try {
			np.join();
			lp.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println(p.index);
	}
}
