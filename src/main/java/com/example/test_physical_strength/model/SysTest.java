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
public class SysTest implements Serializable {
    /**  */
    private Long id;

    /** 学生id */
    private Integer sysUserStudentId;

    /** 项目id */
    private Integer sysProjectId;

    /** 班级id */
    private Integer sysClass;

    /** 预约人数 */
    private String studentNum;

    /** 预约时间 */
    private String advice;

    /** 类型 1、体测预约 2、补考 3、缓测 4、免测 */
    private Short type;

    /** 测试原因 */
    private String reason;

    /** 类型 0、待审核 1、审核通过 2、不同意 */
    private Short status;

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

    public Integer getSysClass() {
        return sysClass;
    }

    public void setSysClass(Integer sysClass) {
        this.sysClass = sysClass;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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
        sb.append(", sysClass=").append(sysClass);
        sb.append(", studentNum=").append(studentNum);
        sb.append(", advice=").append(advice);
        sb.append(", type=").append(type);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}