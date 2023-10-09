package com.gankki.demo.test.copytest;

import org.springframework.beans.BeanUtils;

/**
 * 测试 copy 用
 * @auth liuhao
 * @version 1.0
 * @date 2023/10/9 10:05
 */
public class Test {

    /**
     * BeanUtils.copyProperties 复制的对象必须属性名和类型都一致才可以
     *
     * @param args
     */
    public static void main(String[] args) {
        MtMedicalInsuranceListPatient patient = new MtMedicalInsuranceListPatient();
        patient.setBabyBrithWeight("1");
        patient.setBabyAdmissionWeight("1");

        SlSettlementPatient slSettlementPatient = new SlSettlementPatient();

        BeanUtils.copyProperties(patient, slSettlementPatient);

        System.out.println(slSettlementPatient.toString());

    }

}
