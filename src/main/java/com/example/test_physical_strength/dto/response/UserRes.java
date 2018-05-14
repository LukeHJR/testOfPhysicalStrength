package com.example.test_physical_strength.dto.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
public class UserRes {

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("学号/教师编号")
    private String sid;

    @ApiModelProperty("年级id")
    private Integer sysGrade;

    @ApiModelProperty("班级号")
    private Integer sysClass;

    @ApiModelProperty("是否是班长 0、不是 1、是")
    private Integer monitor;

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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
