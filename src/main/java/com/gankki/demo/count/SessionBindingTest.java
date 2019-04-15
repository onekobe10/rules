package com.gankki.demo.count;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * HttpSessionListener 监控所有session的创建于销毁
 * HttpSessionAttributeListener 监控所有session中属性的添加，删除与替换	
 * HttpSessionBindingListener监控的是特定对象，当前对象被作为属性放入到session中时会被监控到，效率更高
 * HttpSessionActivationListener 监控的是session对象的钝化与活化
 * @author liuhao	
 *
 * 2018年1月29日
 */
public class SessionBindingTest implements HttpSessionBindingListener, HttpSessionActivationListener{

	private String userId;
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println(userId+"...............绑定");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println(userId+"...............销毁");
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		// 钝化 内存-->硬盘
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		// 活化 硬盘-->内存
	}
	
	

}
