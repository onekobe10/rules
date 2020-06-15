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
        //Objects. requireNonNull(fileName);

        // 12. Optional 的使用场景，和 Stream 结合使用更合适
        /*
        public List<FundShare> calculationHqUserMakeValue(List<FundShare> allFundShareList) {
            return Optional.ofNullable(allFundShareList)
                    .orElseGet(Collections::emptyList)
                    .stream().filter(fundShare -> Objects.equals("210012", fundShare.getFundcode())).collect(Collectors.toList());
        }
        */

        // 13. Stream 分页， pageNum = 1
        /*
        fundGroupTradeEntityList = fundGroupTradeEntityList.stream().
                skip((pageNum - 1) * pageSize).
                limit(pageSize).collect(Collectors.toList());
        */

        // 14. 数组删除元素
        // 正序删多个可能会导致IndexOutOfBoundsException
        // 倒序删不需要管理size，没有下标越界问题
        // Java 8 推荐使用 removeIf 方法删除
        List<String> removeList = new ArrayList<>();
        removeList.add("1");
        removeList.add("2");
        removeList.add("3");
        removeList.add("11");
        removeList.removeIf(s -> s.startsWith("1"));
        // [2, 3]
        System.out.println(removeList.toString());

        //  15. MyBatisPlus 分页使用和批量更新
        /*
        1. 配置分页连接器
        @Configuration
        public class MybatisPlusConfig {
            @Bean
            public PaginationInterceptor paginationInterceptor() {
                return new PaginationInterceptor();
            }
        }
        2. 使用 Page 分页类，调用 BaseMapper 的 selectPage 方法即可
        int indexPage = 1;
        LambdaQueryWrapper<TradeRecordEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TradeRecordEntity::getType, 10);
        Page<TradeRecordEntity> page = new Page<>(indexPage, 100);
        List<TradeRecordEntity>  tradeRecordEntityList = tradeRecordMapper.selectPage(page, queryWrapper).getRecords();

        3. MyBatisPlus 的批量更新
        LambdaQueryWrapper<TradeRecordEntity> queryWrapper2 = new LambdaQueryWrapper<>();
        queryWrapper2.eq(TradeRecordEntity::getType, 10);
        queryWrapper2.eq(TradeRecordEntity::getFundcode, fundCode);

        TradeRecordEntity fundTypeEntity = new TradeRecordEntity();
        fundTypeEntity.setFundType(Integer.valueOf(fundType));
        // 只能 fundTypeEntity 中非空的属性，如果为空则不能更新
        // 如果想把一个属性设置为 NULL，则不能使用这种批量更新方式
        tradeRecordMapper.update(fundTypeEntity, queryWrapper2);

        */























    }

}
