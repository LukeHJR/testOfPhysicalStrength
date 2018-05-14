package com.example.test_physical_strength.service;

import com.example.test_physical_strength.dto.PageRequestBean;
import com.example.test_physical_strength.dto.request.UserRequest;
import com.example.test_physical_strength.dto.response.RoleScoreRes;
import com.example.test_physical_strength.dto.response.UserRes;
import com.github.pagehelper.PageInfo;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-12
 */
public interface RoleService {

    /**
     * @param
     * @return
     * @title 用户列表
     * @author huangjiarui
     * @date 2018年5月12日
     */
    PageInfo<UserRes> userList(PageRequestBean requestBean);

    /**
     * @param
     * @return
     * @title 按年纪/项目统计体测成绩
     * @author huangjiarui
     * @date 2018年5月12日
     */
    PageInfo<RoleScoreRes> scoreList(int sysGrade, int projectId, PageRequestBean request);

    /**
     * @param
     * @return
     * @title 修改信息
     * @author huangjiarui
     * @date 2018年5月12日
     */
    void modifyUserInfo(UserRequest request);
}
