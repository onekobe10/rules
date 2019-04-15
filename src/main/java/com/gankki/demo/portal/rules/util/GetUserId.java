package com.gankki.demo.portal.rules.util;

/**
 * @name GetUserId.java
 * @comment
 * @date 2016年4月18日
 * @auth yuanmei
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 得到当前登录用户
 * @name
 * @author yuanmei
 * @date 2016-3-22
 */
@Controller
@RequestMapping("getUser")
public class GetUserId {

    public static String get(HttpServletRequest request, HttpServletResponse response) {
        String userId = (String) request.getSession().getAttribute("userId");//从session里获取userId
        //如果userId为空，查看request里的token参数
        if (null == userId || "".equals(userId)) {
            String userIdDes = request.getParameter("userIdDes");
            if (null == userIdDes || "".equals(userIdDes)) {
                System.out.println("request里没有token参tgt数");
                return "";
            } else {
                DESUtil des;
                try {
                    des = new DESUtil();
                    userId = des.decrypt(userIdDes);//把token转换成userId
                    request.getSession().setAttribute("userId", userId);
                    request.getSession().setAttribute("userIdDes", userIdDes);
                    return userId;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("jiake GetUserId--get k--:" + request.getSession().getAttribute("userId"));
        return userId;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public void userid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        if (userId != null && !userId.equals("")) {
            request.getSession().setAttribute("userId", userId);
        }

        //request.getRequestDispatcher("jiake/jk/leadHome/main");
        response.sendRedirect("../infopub/ApplicationCustomView");
        System.out.println("custom GetUserId userssid --: " + userId);
    }
}

