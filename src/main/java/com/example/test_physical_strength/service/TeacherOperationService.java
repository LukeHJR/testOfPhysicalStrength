package com.example.test_physical_strength.service;


import com.example.test_physical_strength.dto.PageRequestBean;
import com.example.test_physical_strength.dto.request.StrudentRScoreRequest;
import com.example.test_physical_strength.dto.response.StudentRScoreRes;
import com.example.test_physical_strength.dto.response.TestRes;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-12
 */
public interface TeacherOperationService {

    /**
     * @param
     * @return
     * @title   学生成绩列表
     * @author huangjiarui
     * @date 2018年5月12日
     */
    PageInfo<StudentRScoreRes> studentScoreList(PageRequestBean requestBean);

    /**
     * @param
     * @return
     * @title   学生成绩修改
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void modifyScore(Long sysUserStudentId , Long achievement);

    /**
     * @param
     * @return
     * @title   学生成绩删除
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void deleteScore(Long sysUserStudentId);

    /**
     * @param
     * @return
     * @title   学生成绩添加
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void addScore(StrudentRScoreRequest request);

    /**
     * @param
     * @return
     * @title   根据班级号得到学生成绩报表
     * @author huangjiarui
     * @date 2018年5月12日
     */
    PageInfo<StudentRScoreRes> studentScoreList(Long sysClass, PageRequestBean requestBean);

    /**
     * @param
     * @return
     * @title   学生体测预约、补考、缓测、免测列表
     * @author huangjiarui
     * @date 2018年5月12日
     */
    PageInfo<TestRes> studentTestList(PageRequestBean requestBean);

    /**
     * @param
     * @return
     * @title   学生体测预约、补考、缓测、免测审核
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void checkStatus(Long id, Short status);


}
