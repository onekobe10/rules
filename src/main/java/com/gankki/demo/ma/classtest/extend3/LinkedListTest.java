package com.gankki.demo.ma.classtest.extend3;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/7/16
 */
public class LinkedListTest {

	public void testMethod(){
		Node<String> node = new Node(null, "1", null);
	}
	private static class Node<E> {
		E item;
		LinkedListTest.Node<E> next;
		LinkedListTest.Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
