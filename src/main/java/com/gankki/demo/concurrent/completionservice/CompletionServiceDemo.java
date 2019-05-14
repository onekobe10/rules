package com.gankki.demo.concurrent.completionservice;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/14
 */
public class CompletionServiceDemo {
	static class UrlTitleParser implements Callable<String> {
		private String url;

		public UrlTitleParser(String url) {
			this.url = url;
		}

		@Override
		public String call() throws Exception {
			Document doc = Jsoup.connect(url).get();
			Elements elements = doc.select("head title");
			if (elements.size() > 0) {
				return url + ": " + elements.get(0).text();
			}
			return null;
		}
	}

	/**
	 * 在parse方法中，首先创建了一个ExecutorService，然后才是CompletionService，通过后者提交任务、按完成顺序逐个处理结果
	 * @param urls
	 * @throws InterruptedException
	 */
	public static void parse(List<String> urls) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		try {
			CompletionService<String> completionService = new ExecutorCompletionService<>(
					executor);
			for (String url : urls) {
				completionService.submit(new UrlTitleParser(url));
			}
			// 完成一个处理一个
			for (int i = 0; i < urls.size(); i++) {
				Future<String> result = completionService.take();
				try {
					System.out.println(result.get());
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} finally {
			executor.shutdown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		List<String> urls = Arrays.asList(new String[] {
				"http://www.cnblogs.com/swiftma/p/5396551.html",
				"http://www.cnblogs.com/swiftma/p/5399315.html",
				"http://www.cnblogs.com/swiftma/p/5405417.html",
				"http://www.cnblogs.com/swiftma/p/5409424.html" });
		parse(urls);
	}
}
