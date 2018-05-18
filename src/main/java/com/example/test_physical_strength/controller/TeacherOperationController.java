package com.example.test_physical_strength.controller;

import com.example.test_physical_strength.dto.PageRequestBean;
import com.example.test_physical_strength.dto.request.StrudentRScoreRequest;
import com.example.test_physical_strength.dto.response.StudentRScoreRes;
import com.example.test_physical_strength.dto.response.StudentScoreRes;
import com.example.test_physical_strength.dto.response.TestRes;
import com.example.test_physical_strength.model.SysUser;
import com.example.test_physical_strength.service.TeacherOperationService;
import com.example.test_physical_strength.util.ResponseObject;
import com.example.test_physical_strength.util.ResponseObjectUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
@RequestMapping("/teacherOperationController")
@RestController
@Api(description = "教师模块")
public class TeacherOperationController {


    @Autowired
    private TeacherOperationService teacherOperationService;

    @PostMapping("/modifyScore")
    @ApiOperation(value = "学生成绩修改" ,notes = "sysUserStudentId 学生账号表ID ，achievement 成绩 ")
    public ResponseObject<Void> modifyScore(Long sysUserStudentId,Long achievement) {
        teacherOperationService.modifyScore(sysUserStudentId,  achievement);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/deleteScore")
    @ApiOperation(value = "学生成绩删除")
    public ResponseObject<Void> deleteScore(Long sysUserStudentId) {
        teacherOperationService.deleteScore(sysUserStudentId);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/addScore")
    @ApiOperation(value = "学生成绩添加")
    public ResponseObject<Void> addScore(StrudentRScoreRequest request) {
        teacherOperationService.addScore(request);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/checkStatus")
    @ApiOperation(value = "学生体测预约、补考、缓测、免测审核")
    public ResponseObject<Void> checkStatus(Long id, Short status) {
        teacherOperationService.checkStatus(id, status);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/studentScoreList")
    @ApiOperation(value = "学生成绩列表")
    public ResponseObject<PageInfo<StudentRScoreRes>> studentScoreList(PageRequestBean requestBean) {
        PageInfo<StudentRScoreRes> res = teacherOperationService.studentScoreList(requestBean);
        return ResponseObjectUtil.success(res);
    }

    @PostMapping("/studentScoreList1")
    @ApiOperation(value = "根据班级号得到学生成绩报表" ,notes = "Long sysClass 班级号")
    public ResponseObject<PageInfo<StudentRScoreRes>> studentScoreList(Long sysClass, PageRequestBean requestBean) {
        PageInfo<StudentRScoreRes> res = teacherOperationService.studentScoreList(sysClass, requestBean);
        return ResponseObjectUtil.success(res);
    }

    @PostMapping("/studentTestList")
    @ApiOperation(value = "学生体测预约、补考、缓测、免测列表")
    public ResponseObject<PageInfo<TestRes>> studentTestList(PageRequestBean requestBean) {
        PageInfo<TestRes> res = teacherOperationService.studentTestList(requestBean);
        return ResponseObjectUtil.success(res);
    }
}
