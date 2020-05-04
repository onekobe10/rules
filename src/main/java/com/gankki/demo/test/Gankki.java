package com.gankki.demo.test;


import cn.hutool.http.HttpUtil;
import com.beust.jcommander.internal.Lists;
import com.gankki.demo.dto.MapReduceDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.math.BigDecimal;
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
        HttpUtil.post("http://www.baidu.com", "body",60000);

        // 6. 浮点型的计算会丢失精度，使用BigDecimal的String构造器来解决商业运算上丢失精度的问题。
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.02");
        System.out.println(1.01 + 1.02);
        System.out.println(a.add(b));
        System.out.println(c.add(d));
        
        // 7. 字符串占位符
        // throw new BizRuntimeException(String.format("订单(%s)不存在", orderId));
        System.out.println(String.format("订单(%s)不存在", 1));

        // 8. 输出结果 1,3
        List<String> list = Arrays.asList("1", "2", "3");
        list.stream().forEach(s -> {
                    if (Objects.equals("2", s)) {
                        // forEach 中 return 相当于 for 循环中的 continue
                        return;
                    }
                    System.out.println(s);
                }
        );

        // 9. Stream mapReduce 函数的使用
        List<MapReduceDto> profitHistoryList = new ArrayList<>();
        BigDecimal totalNum = profitHistoryList.stream().map(MapReduceDto::getNum).reduce(BigDecimal.ZERO, BigDecimal::add);
        //Map<String, Integer> map = list.stream().collect(Collectors.toMap(Entity::getKey, Entity::getValue));

        // 10. List中删除数据
        List<String> expList = Lists.newArrayList();
        expList.removeIf("3"::equals);

        // 11. throw early catch late
        String fileName = null;
        Objects. requireNonNull(fileName);

        // 12. Optional 的使用场景，和 Stream 结合使用更合适
        /*
        public List<FundShare> calculationHqUserMakeValue(List<FundShare> allFundShareList) {
            return Optional.ofNullable(allFundShareList)
                    .orElseGet(Collections::emptyList)
                    .stream().filter(fundShare -> Objects.equals("210012", fundShare.getFundcode())).collect(Collectors.toList());
        }
        */
    }

}
