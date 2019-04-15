package com.gankki.demo.core36.queue;

import java.util.*;

/**
 *@desc 队列相关
 *@author liuhao
 *@createDate 2019/2/25
 */
public class QueueTest {

	public static void main(String[] args){
		Queue<String> queue = new LinkedList<>();
		Map map = new HashMap();
		//追加元素
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		//从队首取出元素并删除
		String poll = queue.poll();
		System.out.println(poll);
		System.out.println(queue);
		//从队首取出元素但是不删除
		String peek = queue.peek();
		System.out.println(peek);
		System.out.println(queue);
		//遍历队列，这里要注意，每次取完元素后都会删除，整个
		//队列会变短，所以只需要判断队列的大小即可
		while(queue.size() > 0) {
			System.out.println(queue.poll());
		}

		System.out.println("------------------------------");

		Deque<String> arrayQueue = new ArrayDeque<>(3);
		arrayQueue.addFirst("aaa");
		arrayQueue.addFirst("bbb");
		arrayQueue.addFirst("ccc");
		arrayQueue.addFirst("ddd");
		arrayQueue.addLast("111");
		arrayQueue.addLast("222");
		arrayQueue.addLast("333");
		arrayQueue.addLast("444");
		arrayQueue.addFirst("sss");
		arrayQueue.addFirst("hhh");
		arrayQueue.addLast("yyy");
		arrayQueue.addLast("kkk");
		System.out.println(arrayQueue.toString());

		Queue arrayList = new ArrayDeque();
		System.out.println(-1 & 15);
		System.out.println(14 & 15);


		System.out.println(1 & 15);
		System.out.println(2 & 15);

		System.out.println(-1 & 15);
		System.out.println(14 & 8);
		System.out.println(15 & 16);
		System.out.println(1 & 15);

		Queue<Integer> pq = new PriorityQueue<>();
		pq.offer(10);
		pq.offer(10);
		pq.add(22);
		pq.addAll(Arrays.asList(11, 12, 34, 2, 7, 4, 15, 12, 8, 6, 19, 13));
		while(pq.peek()!=null){
			System.out.print(pq.poll() + " ");
		}
		System.out.println("\n.....................");
		Queue<Task> tasks = new PriorityQueue<>(11, taskComparator);
		tasks.offer(new Task(10, "看电视"));
		tasks.offer(new Task(20, "写日记"));

		Task task = tasks.poll();
		while(task!=null){
			System.out.print("处理任务: "+task.getName()
					+"，优先级:"+task.getPriority()+"\n");
			task = tasks.poll();
		}


		List<String> arrayList2 = new ArrayList<>();
		arrayList2.add("111");
		arrayList2.add("123");
		for (String s : arrayList2) {
			if ("123".equals(s)) {
				arrayList2.remove(s);
			}
		}

		System.out.println(arrayList2);

	}

	private static Comparator<Task> taskComparator = new Comparator<Task>() {

		@Override
		public int compare(Task o1, Task o2) {
			if(o1.getPriority()<o2.getPriority()){
				return -1;
			}else if(o1.getPriority()>o2.getPriority()){
				return 1;
			}
			return 0;
		}
	};
}
