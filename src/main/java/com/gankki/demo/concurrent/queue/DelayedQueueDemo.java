package com.gankki.demo.concurrent.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/13
 */
public class DelayedQueueDemo {

	private static final AtomicLong taskSequencer = new AtomicLong(0);

	static class DelayedTask implements Delayed {

		private long runTime;
		private long sequence;
		private Runnable task;

		public DelayedTask(int delayedSeconds, Runnable task) {
			this.runTime = System.currentTimeMillis() + delayedSeconds * 1000;
			this.sequence = taskSequencer.getAndIncrement();
			this.task = task;
		}

		@Override
		public int compareTo(Delayed o) {
			if (o == this) {
				return 0;
			}
			if (o instanceof DelayedTask) {
				DelayedTask other = (DelayedTask) o;
				if (runTime < other.runTime) {
					return -1;
				} else if (runTime > other.runTime) {
					return 1;
				} else if (sequence < other.sequence) {
					return -1;
				} else {
					return 1;
				}
			}
			throw new IllegalArgumentException();
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(runTime - System.currentTimeMillis(),
					TimeUnit.MICROSECONDS);
		}

		public Runnable getTask() {
			return task;
		}
	}

	/**
	 * DelayedTask表示延时任务，只有延时过期后任务才会执行，任务按延时时间排序，延时一样的按照入队顺序排序。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		DelayQueue<DelayedTask> tasks = new DelayQueue<>();
		tasks.put(new DelayedTask(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("execute delayed task");
			}
		}));

		DelayedTask task = tasks.take();
		task.getTask().run();
	}
}
