package com.gankki.demo.portal.rules.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 其他Test
 * @author liuhao	
 *
 * 2017年8月17日
 */
@Controller
@RequestMapping("log4j")
public class Log4jTest {
	
		private static final Logger file = Logger.getLogger("file");
	    private static final Logger register = Logger.getLogger("register");
	    private static final Logger login = Logger.getLogger("login");
	
	@RequestMapping("test")
	public void test() {
		System.out.println(1);
		file.info("file info");
		file.warn("file warn");
		register.debug("register debug");
		register.info("register info");
		login.debug("login debug");
		login.info("login info");
	}
}
