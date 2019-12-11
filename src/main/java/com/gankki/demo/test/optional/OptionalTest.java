package com.gankki.demo.test.optional;

import java.util.Optional;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/9/2
 */
public class OptionalTest {
    
    
    public static void main(String[] args) {
        OptionBean optionBean1 = new OptionBean();
        Optional<OptionBean> optional = Optional.of(optionBean1);
        String flag = optional.isPresent() ? "1" : "2";
        System.out.println(optional.get().toString());

        optionBean1 = null;
        Optional<OptionBean> optional2 = Optional.ofNullable(optionBean1);
        System.out.println(optional2.isPresent() ? "true" : "false");

        Optional.of("123").ifPresent(s -> {
            System.out.println(s);
        });

        System.out.println("orelse............start.......");
        System.out.println(Optional.ofNullable(null).orElse("else"));
        System.out.println(Optional.ofNullable("1").orElse("else"));

        System.out.println(Optional.ofNullable(null).orElseGet(() -> "123"));
        System.out.println(Optional.ofNullable("2 ").orElseGet(() -> "456"));
        System.out.println("orelse.............end......");
        try {
            Optional.ofNullable(null).orElseThrow(() -> {
                throw new NullPointerException("111");
            });

            Optional.ofNullable(null).orElseThrow(() -> {
                throw new RuntimeException("111");
            });
        } catch (Throwable e) {
            System.out.println("test optional orElseThrow");
            e.printStackTrace();
        }

        OptionBean optionBean2 = new OptionBean();
        optionBean2.setUserName("username");
        optionBean2.setPassword("password");

        System.out.println(Optional.ofNullable(optionBean2).map(OptionBean::getUserName).get());
        System.out.println(Optional.ofNullable(optionBean2).filter(bean -> "username".equals(bean.getUserName())).map(OptionBean::getUserName).orElse("haha"));
        System.out.println(Optional.ofNullable(optionBean2).filter(bean -> "Gankki".equals(bean.getUserName())).map(OptionBean::getUserName).orElse("haha"));


    }

}
