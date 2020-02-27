package com.gankki.demo.test.bigdecimal;

import com.beust.jcommander.internal.Lists;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author liuhao
 * @date 2020/2/24
 */
public class DivideTest {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("45000.00");
        BigDecimal b = new BigDecimal("9500");
        BigDecimal[] c = a.divideAndRemainder(b);

        System.out.println("整数部分：" + c[0].toString() + "   小数部分：" + c[1].toString());

        BigDecimal d = a.divide(b,0,BigDecimal.ROUND_DOWN);
        System.out.println(d.toString());

        Assert.notNull(a);

        //String result = HttpUtil.get("/confirmQuickTransferState?startDate",60000);

        // 十以内的随机数
        int number = new Random().nextInt(10) + 1;
        System.out.println(number);

        List<String> list =  Lists.newArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        int listSize = list.size();
        Map<Long, BigDecimal> userMap = new HashMap<>((int) Math.ceil(listSize * 4.0 / 3));
        System.out.println(userMap.size());

    }

}
