package com.example.test_physical_strength.controller;

import com.example.test_physical_strength.annotation.Open;
import com.example.test_physical_strength.dto.request.LoginRequest;
import com.example.test_physical_strength.dto.request.RegistRequest;
import com.example.test_physical_strength.dto.response.LoginRes;
import com.example.test_physical_strength.model.SysInfo;
import com.example.test_physical_strength.service.IndexInfoService;
import com.example.test_physical_strength.util.ResponseObject;
import com.example.test_physical_strength.util.ResponseObjectUtil;
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
 * @date: 2018-05-12
 */
@RequestMapping("/indexInfoController")
@RestController
@Api(description = "首页公告")
public class IndexInfoController {

     @Autowired
     private IndexInfoService indexInfoService;

    @PostMapping("/indexInfo")
    @ApiOperation(value = "公告信息")
    public ResponseObject<List<SysInfo>> indexInfo() {
        List<SysInfo> res = indexInfoService.indexInfo();
        return ResponseObjectUtil.success(res);
    }

    @Open
    @PostMapping("/indexAddInfo")
    @ApiOperation(value = "添加公告信息")
    public ResponseObject<Void> indexAddInfo(String title , String content) {
        indexInfoService.indexAddInfo(title,content);
        return ResponseObjectUtil.success();
    }
}
