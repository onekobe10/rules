package com.gankki.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args) {

        String str = "有12只猫和13只狗。";
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());


        String str1 = "有12只猫和13只狗。";
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str1);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

}
