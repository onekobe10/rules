package com.gankki.demo.portal.rules.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoticeContextHolder {
	/**
	 * spring 上下斄1�7�1�7
	 */
	private ApplicationContext ctx = null;

	private static NoticeContextHolder holder = null;

	/**
	 * 单例,通过该方法获取实侄1�7�1�7
	 * 
	 * @return
	 */
	public static NoticeContextHolder getInstance(String xmlPath) {

		if (holder == null) {
			holder = new NoticeContextHolder(xmlPath);
		}
		return holder;
	}

	/**
	 * @param ctx
	 *            the ctx to set
	 */
	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	/**
	 * the ctx to get
	 */
	public ApplicationContext getCtx() {
		return this.ctx;
	}

	/**
	 * 获取bean
	 * 
	 * @param beanId
	 *            beanId
	 * @return 返回spring配置的对豄1�7�1�7
	 */
	public Object getBean(String beanId) {
		return ctx.getBean(beanId);
	}

	private NoticeContextHolder(String xmlPath) {
		String[] fn = new String[] { xmlPath };
		ctx = new ClassPathXmlApplicationContext(fn);
	}
}
