package com.gankki.demo.portal.rules.util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 过滤请求,如果在request上面没有发现userId，则返回出错页面
 * 
 * @author liuwenzhang
 *
 */
public class CheckUserIdFilter implements Filter {

	private FilterConfig config;
	private static final Logger logger=Logger.getLogger(CheckUserIdFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取userId
		String userId = GetUserId.get((HttpServletRequest) request,
				(HttpServletResponse) response);
		//如果session里没有userId,那么跳转到错误返回页面；
		if (userId == null || userId.trim().equals("")) {
			String dispatcherPage = config.getInitParameter("dispatcherPage");
			System.out.println("userId为空，跳转到错误页面： "+dispatcherPage);
			request.getRequestDispatcher(dispatcherPage).forward(request,
					response);
		}else{
			//调用4a接口获得userid,保存在session里
			chain.doFilter(request, response);
		}


	}

	@Override
	public void destroy() {

	}

}
