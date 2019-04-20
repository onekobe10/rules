package com.gankki.demo.ma;

import java.util.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/1
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.offer(10);
		pq.add(22);
		pq.addAll(Arrays.asList(new Integer[]{
				11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13}));
		while (pq.peek() != null) {
			System.out.print(pq.poll() + " ");
		}
		
		System.out.println("\n..........................\n");
		
		Queue<Task> tasks = new PriorityQueue<Task>(11, PriorityQueueTest.taskComparator);
		tasks.offer(new Task(20, "写日记"));
		tasks.offer(new Task(10, "看电视"));
		tasks.offer(new Task(100, "写代码"));

		Task task = tasks.poll();
		while(task!=null){
			System.out.print("处理任务: "+task.getName()
					+"，优先级:"+task.getPriority()+"\n");
			task = tasks.poll();
		}

		System.out.println("\n..........................\n");

		Queue<Integer> pq2 = new PriorityQueue<>();
		pq2.add(1);
		pq2.add(4);
		pq2.add(3);
		System.out.println(pq2.toString());
		while (pq2.peek() != null) {
			System.out.println(pq2.poll() + " ");
		}

		Queue<Integer> pq3 = new PriorityQueue<>(5, Comparator.reverseOrder());
		pq3.add(5);
		pq3.add(4);
		pq3.add(1);
		pq3.add(3);
		pq3.add(2);
		pq3.add(8);
		System.out.println(pq3.toString());
	}

	static class Task {
		int priority;
		String name;

		public Task(int priority, String name) {
			this.priority = priority;
			this.name = name;
		}

		public int getPriority() {
			return priority;
		}

		public String getName() {
			return name;
		}
	}

	private static Comparator<Task> taskComparator = new Comparator<Task>() {

		@Override
		public int compare(Task o1, Task o2) {
			if(o1.getPriority() > o2.getPriority()){
				return -1;
			}else if(o1.getPriority() < o2.getPriority()){
				return 1;
			}
			return 0;
		}
	};
}
