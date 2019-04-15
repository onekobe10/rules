package com.gankki.demo.phone.model;

/**
 * 电话通知对象bean
 *
 * @author liuhao
 * <p>
 * 2017年12月5日
 */
public class PhoneInformObject {
    private String id;//主键id
    private String name;//姓名
    private String phone;//电话
    private String department;//部门
    private String position;//职位

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
