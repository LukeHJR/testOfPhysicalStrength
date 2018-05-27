package com.example.test_physical_strength.controller;

import com.example.test_physical_strength.annotation.Open;
import com.example.test_physical_strength.dto.PageRequestBean;
import com.example.test_physical_strength.dto.request.UserRequest;
import com.example.test_physical_strength.dto.response.RoleScoreRes;
import com.example.test_physical_strength.dto.response.UserRes;
import com.example.test_physical_strength.model.SysInfo;
import com.example.test_physical_strength.service.RoleService;
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
@RequestMapping("/roleController")
@RestController
@Api(description = "首页公告")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/userList")
    @ApiOperation(value = "userList")
    public ResponseObject<PageInfo<UserRes>> userList(PageRequestBean requestBean) {
        PageInfo<UserRes> res = roleService.userList(requestBean);
        return ResponseObjectUtil.success(res);
    }

    @PostMapping("/scoreList")
    @ApiOperation(value = "scoreList")
    public ResponseObject<PageInfo<RoleScoreRes>> scoreList(int sysGrade, int projectId, PageRequestBean request) {
        PageInfo<RoleScoreRes> res = roleService.scoreList(sysGrade, projectId, request);
        return ResponseObjectUtil.success(res);
    }


    @PostMapping("/modifyUserInfo")
    @ApiOperation(value = "修改信息")
    public ResponseObject<Void> modifyUserInfo(UserRequest request) {
        roleService.modifyUserInfo(request);
        return ResponseObjectUtil.success();
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除")
    public ResponseObject<Void> delete(Long id) {
        roleService.delete(id);
        return ResponseObjectUtil.success();
    }
}
