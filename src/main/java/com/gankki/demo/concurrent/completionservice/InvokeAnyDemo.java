package com.gankki.demo.concurrent.completionservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class InvokeAnyDemo {

	static class SearchTask implements Callable<String> {
		private String engine;
		private String keyword;

		public SearchTask(String engine, String keyword) {
			this.engine = engine;
			this.keyword = keyword;
		}

		@Override
		public String call() throws Exception {
			// 模拟从给定引擎搜索结果
			Thread.sleep(1000);
			return "<result for> " + keyword;
		}
	}

	public static String search(List<String> engines, String keyword)
			throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletionService<String> cs = new ExecutorCompletionService<>(executor);
		List<Future<String>> futures = new ArrayList<Future<String>>(
				engines.size());
		String result = null;
		try {
			for (String engine : engines) {
				futures.add(cs.submit(new SearchTask(engine, keyword)));
			}
			for (int i = 0; i < engines.size(); i++) {
				try {
					result = cs.take().get();
					if (result != null) {
						break;
					}
				} catch (ExecutionException e) {
					// 出现异常，结果无效，继续
					e.printStackTrace();
				}
			}
		} finally {
			// 取消所有任务，对于已完成的任务，取消没有什么效果
			for (Future<String> f : futures){
				f.cancel(true);
			}
			executor.shutdown();
		}
		return result;
	}

	/**
	 * SearchTask模拟从指定搜索引擎查询结果，search利用CompletionService/ExecutorService执行并发查询，
	 * 在得到第一个有效结果后，取消其他任务。
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		List<String> engines = Arrays.asList("www.baidu.com",
				"www.sogou.com", "www.so.com", "www.google.com");
		System.out.println(search(engines, "老马说编程"));
	}
}
