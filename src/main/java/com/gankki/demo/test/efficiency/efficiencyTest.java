package com.gankki.demo.test.efficiency;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Efficieny 测试
 * @author liuhao
 * @date 2020/2/29
 */
public class efficiencyTest {

    /**
     * <<  表示左移，不分正负数，低位补0
     * >>  表示右移，如果该数为正，则高位补0，若为负数，则高位补1
     * >>> 表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
     * @param args
     */
    public static void main(String[] args){
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

        List<String> userDOList = new ArrayList<>();
        int userSize = userDOList.size();
        Set<Long> userSet = new HashSet<>(userSize);
        Map<Long, String> userMap = new HashMap<>((int) Math.ceil(userSize * 4.0 / 3));

        String source = "a::1,b::2,c::3,d::4";
        String target = source.replace("::", "=");
        String[] targets = StringUtils.split(source, "::");
        System.out.println(targets[1]);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] integers = integerList.toArray(new Integer[0]);
        System.out.println(integers[4]);
    }



}
