package com.gankki.demo.test;

import com.alibaba.fastjson.JSONObject;
import com.gankki.demo.dto.ExponentFundDto;
import com.gankki.demo.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * knowledge point summary
 *
 * @author liuhao
 * @date 2020/2/29
 */
public class efficient {

    public static void main(String[] args) {
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

        // 6. BigDecimcal, doubleValue、toString在位数够多的情况下都会变成科学计数法，toPlainString则始终精确显示数值本身
        System.out.println(new BigDecimal("0.000000000000001").doubleValue());
        System.out.println(new BigDecimal("0.000000000000001").toString());
        // 科学计数法标识
        System.out.println(new BigDecimal("0.000000000000001").toEngineeringString());
        System.out.println(new BigDecimal("0.000000000000001").toPlainString());

        // 7. alibaba 代码规约
        // 超过 120 个字符的情况下，换行缩进 4 个空格，并且方法前的点号一起换行
        StringBuilder sb = new StringBuilder();
        sb.append("zi").append("xin")
                .append("huang")
                .append("huang")
                .append("huang");
        // 参数很多的方法调用可能超过 120 个字符，逗号后才是换行处
        /*
        method(args1,
               args2,
               args3,
               argsX);
         */

        // 8. 二进制运算
        /*

        原码：
        反码 = 原码按位取反
        补码 = 反码 + 1
        原码 + 补码 = 0

        1. 按位与（&）：两位全为1，结果才为1
        0&0=0；
        0&1=0；
        1&0=0；  
        1&1=1；

        2. 按位或（|）：只要有一个为1，结果就为1
        0|0=0；  
        0|1=1；
        1|0=1；
        1|1=1；

        3. 异或运算（^）：两个相应位为“异”（值不同），则该位结果为1，否则为0
        0^0=0；
        0^1=1；
        1^0=1；
        1^1=0；

        4. 取反运算（~）：对于一个二进制数按位取反，即将0变1，1变0： ~1=0; ~0=1;

        5. 左移运算（<<）：
        将一个运算对象的各二进制位全部左移若干位（左边的二进制丢弃，右边补零） 2<<1 = 4
        若左移时舍弃的高位不包括1，则每左移一位，相当于该数乘以2。 -14（二进制：1111 0010）<< 2= (1100 1000) （高位包括1，不符合规则）

        6. 右移运算（>>）：将一个数的各二进制位全部右移若干位，正数左补0，负数左补1，右边丢弃。操作数每右移一位，相当于该数除以2.
        左补0 or 补1 得看被移数是正还是负。
        例：4 >> 2 = 1
        例：-14(1111 0010) >> 2 = -4 (1111 1100 )

        7. 无符号右移运算（>>>）：各个位向右移指定的位数。右移后左边突出的位用零来填充。移出右边的位被丢弃
        例如： -14>>>2
        即-14（1111 1111 1111 1111 1111 1111 1111 0010）>>> 2
        =（0011 1111 1111 1111 1111 1111 1111 1100）
        = 1073741820

        */


    }

}
