package com.example.test_physical_strength.dto.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
public class StrudentRScoreRequest {

    @ApiModelProperty("学号")
    private Integer sid;

    @ApiModelProperty("锻炼意见")
    private String advice;

    @ApiModelProperty("个人成绩")
    private Integer achievement;

    @ApiModelProperty("项目id")
    private Integer sysProjectId;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public Integer getSysProjectId() {
        return sysProjectId;
    }

    public void setSysProjectId(Integer sysProjectId) {
        this.sysProjectId = sysProjectId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
