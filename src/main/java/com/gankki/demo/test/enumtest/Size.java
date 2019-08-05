package com.gankki.demo.test.enumtest;

import com.alibaba.fastjson.JSONObject;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/8/2
 */
public enum Size {
    SMALL("S","小号"),
    MEDIUM("M","中号"),
    LARGE("L","大号");

    private String abbr;
    private String title;

    /**
     * 枚举的构造方法默认都是 private 的
     * @param abbr
     * @param title
     */
    Size(String abbr, String title){
        this.abbr = abbr;
        this.title = title;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getTitle() {
        return title;
    }

    public static Size fromAbbr(String abbr){
        for(Size size : Size.values()){
            if(size.getAbbr().equals(abbr)){
                return size;
            }
        }
        return null;
    }


    public static void main(String[] args){
        System.out.println(SMALL);
        System.out.println(SMALL.name());
        System.out.println(SMALL.toString());

        System.out.println(SMALL.ordinal());
        System.out.println(MEDIUM.ordinal());
        System.out.println(LARGE.ordinal());

        System.out.println(JSONObject.toJSONString(SMALL));
    }

}
