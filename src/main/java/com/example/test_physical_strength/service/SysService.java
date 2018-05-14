package com.example.test_physical_strength.service;


import com.example.test_physical_strength.dto.request.LoginRequest;
import com.example.test_physical_strength.dto.request.RegistRequest;
import com.example.test_physical_strength.dto.response.LoginRes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-04-24
 */
public interface SysService {

    /**
     * 登录
     *
     * @param request
     * @return
     */
    LoginRes login(LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse req);

    /**
     * 注册
     *
     * @param request
     * @return
     */
    void regist(RegistRequest registRequest, HttpServletRequest request, HttpServletResponse req);
}
