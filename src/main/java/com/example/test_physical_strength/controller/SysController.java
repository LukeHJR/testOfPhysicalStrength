package com.example.test_physical_strength.controller;


import com.example.test_physical_strength.annotation.Open;
import com.example.test_physical_strength.dto.request.LoginRequest;
import com.example.test_physical_strength.dto.request.RegistRequest;
import com.example.test_physical_strength.dto.response.LoginRes;
import com.example.test_physical_strength.service.Session.SessionService;
import com.example.test_physical_strength.service.SysService;
import com.example.test_physical_strength.util.ResponseObject;
import com.example.test_physical_strength.util.ResponseObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-04-25
 */

@RequestMapping("/user")
@RestController
@Api(description = "用户")
public class SysController {

    @Autowired
    private SysService sysService;
    @Autowired
    private SessionService sessionService;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResponseObject<LoginRes> login(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse res) {
        LoginRes loginRes = sysService.login(loginRequest, request, res);
        return ResponseObjectUtil.success(loginRes);
    }

    @Open
    @PostMapping("/regist")
    @ApiOperation(value = "注册")
    public ResponseObject<Void> regist(RegistRequest registRequest, HttpServletRequest request, HttpServletResponse res) {
        sysService.regist(registRequest, request, res);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登出")
    public ResponseObject<Void> logout(HttpServletRequest request) {
        sessionService.logout(request);
        return ResponseObjectUtil.success();
    }

}
