package com.gankki.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * 封装金牛返回的指数型基金数据
 * @author liuhao
 * @date 2020/3/19
 */
@Data
public class ExponentFundDto {
    /**
     * 0000 代表响应成功
     */
    private String code;
    private List<ExponentFundArea> data;
    private String message;

    /**
     * 不同等级的基金分组
     */
    @Data
    private static class ExponentFundArea {
        private String area;
        private String areaContent;
        private String grade;
        private String remark;
        private List<ExponentFundList> list;
    }

    /**
     * 指数温度计基金描述
     */
    @Data
    private static class ExponentFundList {
        private List<ExponentFund> fund;
        private String indexName;
        private String indexCode;
        private String indexContent;
        private String valuaRatio;
        private String areaValue;
    }

    /**
     * 所属级别的指数基金
     */
    @Data
    private static class ExponentFund {
        private String ratingTitle;
        private int dBuyStart;
        private String fundCode;
        private String valuagrState;
        private String declareState;
        private String fundName;
        private String ratingStr;
    }

}
