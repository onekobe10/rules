package com.gankki.demo.test.iftest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StringReplaceClass {

    /**
     * DIP手术名称中的特殊符号转换
     */
    public static Map<String, String> dipOperationNameReplaceMap = new HashMap<String, String>() {
        {
            put("双侧输卵管卵巢切除术，经阴道+腹腔镜", "双侧输卵管卵巢切除术，经阴道，腹腔镜");
        }
    };

    public static void main(String[] args) {
        String k = "双侧输卵管卵巢切除术，经阴道+腹腔镜";
        String operationName = "双侧输卵管卵巢切除术，经阴道+腹腔镜+腹腔镜下子宫广泛性切除术";
        operationName = operationName.replace(k, dipOperationNameReplaceMap.get(k));
        System.out.println(operationName);

        operationName = operationName.replaceAll(k, dipOperationNameReplaceMap.get(k));
        System.out.println(operationName);

        System.out.println(Pattern.quote(k));
        operationName = operationName.replaceAll(Pattern.quote(k), dipOperationNameReplaceMap.get(k));
        System.out.println(operationName);
    }

}
