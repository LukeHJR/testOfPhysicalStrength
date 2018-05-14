package com.example.test_physical_strength.dto.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-04-24
 */
public class RegistRequest {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年级id")
    private Integer sysGrade;

    @ApiModelProperty(value = "班级号")
    private Integer sysClass;

    @ApiModelProperty(value = "学号/教师编号")
    private String sid;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账号类型1、学生用户 2、教师用户 3、管理员用户 ")
    private Short type;


    @ApiModelProperty(value = "确认密码")
    private String rePassword;

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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
