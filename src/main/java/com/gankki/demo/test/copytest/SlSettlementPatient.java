package com.gankki.demo.test.copytest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 医保结算清单-患者基本信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SlSettlementPatient {

    /**
     * 新生儿出生体重
     */
    private String babyBrithWeight;

    /**
     * 新生儿入院体重
     */
    private BigDecimal babyAdmissionWeight;

}