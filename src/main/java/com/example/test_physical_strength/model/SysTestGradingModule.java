package com.example.test_physical_strength.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author hjr
 * @date 2018-05-08
 *
 */
public class SysTestGradingModule implements Serializable {
    /**  */
    private Long id;

    /** 学生id */
    private Integer sysUserStudentId;

    /** 项目id */
    private Integer sysProjectId;

    /** 个人成绩 */
    private Integer achievement;

    /** 锻炼意见 */
    private String advice;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSysUserStudentId() {
        return sysUserStudentId;
    }

    public void setSysUserStudentId(Integer sysUserStudentId) {
        this.sysUserStudentId = sysUserStudentId;
    }

    public Integer getSysProjectId() {
        return sysProjectId;
    }

    public void setSysProjectId(Integer sysProjectId) {
        this.sysProjectId = sysProjectId;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysUserStudentId=").append(sysUserStudentId);
        sb.append(", sysProjectId=").append(sysProjectId);
        sb.append(", achievement=").append(achievement);
        sb.append(", advice=").append(advice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}