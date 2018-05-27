package com.example.test_physical_strength.controller;

import com.example.test_physical_strength.dto.request.MakeUpExamRequest;
import com.example.test_physical_strength.dto.request.SlowMeasuringOrExemptingRequest;
import com.example.test_physical_strength.dto.request.TestReservationRequest;
import com.example.test_physical_strength.dto.request.UserRequest;
import com.example.test_physical_strength.dto.response.StudentScoreRes;
import com.example.test_physical_strength.model.SysUser;
import com.example.test_physical_strength.service.Session.SessionService;
import com.example.test_physical_strength.service.TestOpreationService;
import com.example.test_physical_strength.util.ResponseObject;
import com.example.test_physical_strength.util.ResponseObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
@RequestMapping("/testOpreationController")
@RestController
@Api(description = "学生模块")
public class TestOpreationController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TestOpreationService testOpreationService;

    @PostMapping("/searchScore")
    @ApiOperation(value = "修改信息")
    public ResponseObject<List<StudentScoreRes>> searchScore(HttpServletRequest request) {
        SysUser sysUser = sessionService.getManager(request);
        Long id = sysUser.getId();
        List<StudentScoreRes> res = testOpreationService.searchScore(id);
        return ResponseObjectUtil.success(res);
    }

    @PostMapping("/slowMeasuringOrExempting")
    @ApiOperation(value = "学生缓测、免测申请")
    public ResponseObject<Void> slowMeasuringOrExempting(SlowMeasuringOrExemptingRequest request) {
        testOpreationService.slowMeasuringOrExempting(request);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/makeUpExam")
    @ApiOperation(value = "学生申请补考")
    public ResponseObject<Void> makeUpExam(MakeUpExamRequest request) {
        testOpreationService.makeUpExam(request);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/testReservation")
    @ApiOperation(value = "体测预约")
    public ResponseObject<Void> testReservation(TestReservationRequest request, HttpServletRequest req) {
        SysUser sysUser = sessionService.getManager(req);
        String sid = sysUser.getSid();
        testOpreationService.testReservation(request, sid);
        return ResponseObjectUtil.success();
    }

}
