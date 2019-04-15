package com.gankki.demo.count;

import com.gankki.demo.portal.rules.util.HttpClientUtil;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * session监听器
 *
 * @author liuhao
 * <p>
 * 2018年1月29日
 */
public class TotalPersonsListener implements HttpSessionListener, HttpSessionAttributeListener {

    //只需修改localhost:8082即可
    private String url = "http://localhost:8082/eomsFaultGradingSX/onlineUser/method";


    /**
     * session中添加属性监听方法
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //只获取属性为userId的属性
        if ("userId".equals(se.getName())) {

            //封装参数
            Map<String, String> params = new HashMap<String, String>();
            params.put("flag", "add");
            params.put("userId", (String) se.getValue());

            //调用httpClient工具方法
            HttpClientUtil.doPost(this.url, params);
        }
    }

    /**
     * session销毁监听方法
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        Map<String, String> params = new HashMap<String, String>();
        //封装参数
        params.put("flag", "reduce");
        params.put("userId", (String) se.getSession().getAttribute("userId"));

        //调用httpClient工具方法
        HttpClientUtil.doPost(this.url, params);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // TODO Auto-generated method stub
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // TODO Auto-generated method stub
    }

}
