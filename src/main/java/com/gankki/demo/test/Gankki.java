package com.gankki.demo.test;


import cn.hutool.http.HttpUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.*;

/**
 * @author liuhao
 * @date 2020/2/29
 */
public class Gankki {


    public static void main(String[] args) {
        // 1.通用相等方法
        boolean equals = Objects.equals("name", "thisName");
        System.out.println(equals);

        // 2. 容器判空 org.apache.commons.collections
        List<String> listEmpty = new ArrayList<>();
        CollectionUtils.isNotEmpty(listEmpty);
        CollectionUtils.isEmpty(listEmpty);
        // 2.1 对象判空
        Map<String, String> map = new HashMap<>();
        MapUtils.isNotEmpty(map);

        // 3. 对象判空
        String objectNull = "s";
        if (Objects.isNull(objectNull)) {
            // return null;
        }

        // 4. 空数组，作为方法的返回值，避免了调用方判空
        Collections.emptyList();

        // 5. HttpUtil 工具 retry 机制
        String result = HttpUtil.post("www.baidu.com", "body",60000);


    }

}
