package com.example.test_physical_strength.dto.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
public class RoleScoreRes {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("个人成绩")
    private Integer achievement;

    @ApiModelProperty("项目id")
    private Integer sysProjectId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
