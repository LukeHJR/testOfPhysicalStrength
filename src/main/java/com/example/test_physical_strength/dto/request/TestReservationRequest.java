package com.example.test_physical_strength.dto.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
public class TestReservationRequest {

    @ApiModelProperty(value = "学号")
    private Integer sid;

    @ApiModelProperty(value = "项目id")
    private Integer sysProjectId;

    @ApiModelProperty(value = "班级id")
    private Integer sysClass;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = " 类型 1、体测预约 2、补考 3、缓测 4、免测")
    private Short type;

    @ApiModelProperty(value = " 预约时间")
    private String advice;

    @ApiModelProperty(value = " 类型 1、班级 2、个人")
    private Short status;

    @ApiModelProperty(value = " 预约人数")
    private String studentNum;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
