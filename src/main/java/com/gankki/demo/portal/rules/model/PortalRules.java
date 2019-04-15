package com.gankki.demo.portal.rules.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 规章制度表
 *
 * @author liuhao
 * <p>
 * 2017年7月18日
 */
public class PortalRules {
    private String id; //规章制度主键
    private String theme; //主题
    private String productType; //产品类型
    private String introduce; //简介
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buildDate; //新建日期
    private String buildPerson; //新建人员
    private String remarks; //备注
    private String rules; //规章制度附件

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public String getBuildPerson() {
        return buildPerson;
    }

    public void setBuildPerson(String buildPerson) {
        this.buildPerson = buildPerson == null ? null : buildPerson.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }
}