package com.gankki.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.gankki.demo.dto.ExponentFundDto;
import com.gankki.demo.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * knowledge point summary
 * @author liuhao
 * @date 2020/2/29
 */
public class efficient {

    public static void main(String[] args){
        /* 1.
         <<  表示左移，不分正负数，低位补0
         >>  表示右移，如果该数为正，则高位补0，若为负数，则高位补1
         >>> 表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
         */
        System.out.println("16 << 1 : " + (16 << 1));
        System.out.println("-16 << 1 : " + (-16 << 1));
        System.out.println("16 >> 3 : " + (16 >> 3));
        System.out.println("-16 >> 3 : " + (-16 >> 3));
        // 负数右移做大为 -1
        System.out.println("-16 >> 20 : " + (-16 >> 20));
        // 正数右移最小为 0
        System.out.println("16 >> 10 : " + (16 >> 10));

        System.out.println("16 >>> 2 : " + (16 >>> 2));
        System.out.println("-16 >>> 2 : " + (-16 >>> 4));

        // 在计算机中，负数以其正值的补码形式表达，方法为其绝对值求反加一。
        // 反码：将二进制数按位取反，所得的新二进制数称为原二进制数的反码
        // 补码：反码加1称为补码。
        System.out.println(Integer.toBinaryString(-16));
        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(268435455));

        // 2.指定容器大小
        List<String> userDOList = new ArrayList<>();
        int userSize = userDOList.size();
        Set<Long> userSet = new HashSet<>(userSize);
        Map<Long, String> userMap = new HashMap<>((int) Math.ceil(userSize * 4.0 / 3));

        // 3.推荐的替换方法
        String source = "a::1,b::2,c::3,d::4";
        String target = source.replace("::", "=");
        String[] targets = StringUtils.split(source, "::");
        System.out.println(targets[1]);

        // 4. 推荐的 list 转 array 方式
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] integers = integerList.toArray(new Integer[0]);
        System.out.println(integers[4]);

        // 5. 解析的 Json 串有多层嵌套时，反射的 Class 里面的嵌套对象必须为一个独立的类，或者静态内部类，不能为成员内部类。
        // 成员内部类必须依赖于外部类已经实例化之后才能后才能创建，而反射的时候是外部类与内部类实例化的时候没有关联就会报错。
        Map<String, Object> paramMap = new HashMap(4);
        paramMap.put("clientId", "82bf143f89ac4b119926a13988d4766c");
        String response = HttpUtil.sendGet("http://e-api.jnlc.com/api/jf/getIndicatorInfo", paramMap, 3000, 5000);
        ExponentFundDto exponentFundDto = JSONObject.parseObject(response, ExponentFundDto.class);

    }

}
