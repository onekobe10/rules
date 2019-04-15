package com.gankki.demo.portal.rules.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "count")
public class CountTest {

    @RequestMapping(value = "countTest")
    public String countTest(HttpServletRequest req) {
        String userId = "liuhao";
        HttpSession session = req.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("userId2", userId);
        System.out.println("countTest.......................");
        return "test";
    }

    @RequestMapping(value = "countTest2")
    public String countTest2(HttpServletRequest req) {
        String userId = "liuhao1";
        HttpSession session = req.getSession();
        session.setAttribute("userId", userId);
        System.out.println("countTest.......................");
        return "test";
    }
}
