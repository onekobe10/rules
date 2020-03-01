package com.gankki.demo.test.efficiency;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author liuhao
 * @date 2020/2/29
 */
public class FunctoinTest {


    public static void main(String[] args){
        // 1.通用相等方法
        boolean equals = Objects.equals("name", "thisName");
        System.out.println(equals);

        // 2. 容器判空 org.apache.commons.collections
        List<String> listEmpty = new ArrayList<>();
        CollectionUtils.isNotEmpty(listEmpty);
        CollectionUtils.isEmpty(listEmpty);

        // 3. 对象判空
        String objectNull= "s";
        if (Objects.isNull(objectNull)) {
            // return null;
        }

        // 4. 空数组，作为方法的返回值，避免了调用方判空
        Collections.emptyList();



    }

}
