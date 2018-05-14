package com.example.test_physical_strength.dto.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
public class UserRequest {

    @ApiModelProperty("用户id")
    private int id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年级id")
    private Integer sysGrade;

    @ApiModelProperty("班级号")
    private Integer sysClass;

    @ApiModelProperty("是否是班长 0、不是 1、是")
    private Integer monitor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSysGrade() {
        return sysGrade;
    }

    public void setSysGrade(Integer sysGrade) {
        this.sysGrade = sysGrade;
    }

    public Integer getSysClass() {
        return sysClass;
    }

    public void setSysClass(Integer sysClass) {
        this.sysClass = sysClass;
    }

    public Integer getMonitor() {
        return monitor;
    }

    public void setMonitor(Integer monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
