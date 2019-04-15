package com.gankki.demo.portal.rules.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;

@Controller
public class LogoutController {

    private static final Logger logger = Logger.getLogger("LogoutController");

    /**
     * 注销该模块的登陆状态
     *
     * @author liuwenzhang
     */
    @RequestMapping(value = "logout", produces = "application/Json;charset=UTF-8")
    public @ResponseBody
    String logout(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userId = (String) req.getSession().getAttribute("userId");
        req.getSession().setAttribute("userId", null);
        req.getSession().setAttribute("userIdDes", null);
        req.getSession().setAttribute("token", null);
        JSONObject jo = new JSONObject();
        jo.put("success", true);
        jo.put("message", req.getContextPath() + "注销成功!");
        logger.info(userId + " logout at " + req.getContextPath() + "!");
        return jo.toString();
    }

}
