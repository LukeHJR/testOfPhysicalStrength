package com.example.test_physical_strength.dto.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
public class TestRes {
    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "项目id")
    private Integer sysProjectId;

    @ApiModelProperty(value = "班级id")
    private Integer sysClass;

    @ApiModelProperty(value = " 类型 1、体测预约 2、补考 3、缓测 4、免测")
    private Short type;

    @ApiModelProperty(value = " 预约时间")
    private String advice;

    @ApiModelProperty(value = " 类型 1、班级 2、个人")
    private Short typeStatus;

    @ApiModelProperty(value = " 预约人数")
    private String studentNum;

    @ApiModelProperty(value = " 类型 0、待审核 1、审核通过 2、不同意 ")
    private Short status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSysProjectId() {
        return sysProjectId;
    }

    public void setSysProjectId(Integer sysProjectId) {
        this.sysProjectId = sysProjectId;
    }

    public Integer getSysClass() {
        return sysClass;
    }

    public void setSysClass(Integer sysClass) {
        this.sysClass = sysClass;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Short getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(Short typeStatus) {
        this.typeStatus = typeStatus;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
