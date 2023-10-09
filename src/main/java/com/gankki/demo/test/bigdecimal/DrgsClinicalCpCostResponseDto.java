package com.gankki.demo.test.bigdecimal;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DrgsClinicalCpCostResponseDto {

    private Boolean clinicalFlag;

    //控制预测可用金额
    private Boolean forecastBalanceFeeFlag = Boolean.FALSE;

    private String pathwayName;

    private String unreasonableCost;

    private String pathwayOutCost;

    private OptionOrderCost kxOrder;

    private OptionOrderCost bxOrder;

    private OptionOrderCost kxToEXOrder;

    private OptionOrderCost bxToExOrder;


    @Data
    @Builder
    public static class OptionOrderCost {

        private String yetExecuteCost;

        private String waitExecuteCost;
    }

    public static void main(String[] args) {
        DrgsClinicalCpCostResponseDto build = DrgsClinicalCpCostResponseDto.builder().build();
        System.out.println(JSON.toJSONString(build));
    }

}

