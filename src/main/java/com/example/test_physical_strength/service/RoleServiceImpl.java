package com.example.test_physical_strength.service;

import com.example.test_physical_strength.dto.PageRequestBean;
import com.example.test_physical_strength.dto.request.UserRequest;
import com.example.test_physical_strength.dto.response.RoleScoreRes;
import com.example.test_physical_strength.dto.response.UserRes;
import com.example.test_physical_strength.mapper.SysTestGradingModuleMapper;
import com.example.test_physical_strength.mapper.SysTestMapper;
import com.example.test_physical_strength.mapper.SysUserMapper;
import com.example.test_physical_strength.mapper.SysUserStudentMapper;
import com.example.test_physical_strength.model.SysTestGradingModule;
import com.example.test_physical_strength.model.SysTestGradingModuleExample;
import com.example.test_physical_strength.model.SysUser;
import com.example.test_physical_strength.model.SysUserExample;
import com.example.test_physical_strength.model.SysUserStudent;
import com.example.test_physical_strength.model.SysUserStudentExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserStudentMapper sysUserStudentMapper;

    @Autowired
    private SysTestGradingModuleMapper sysTestGradingModuleMapper;

    @Autowired
    private SysTestMapper sysTestMapper;

    @Override
    public PageInfo<UserRes> userList(PageRequestBean requestBean) {

        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        List<UserRes> res = new ArrayList<>();
        PageHelper.startPage(requestBean.getPageNum(), requestBean.getPageSize(), true);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        PageInfo<UserRes> pageInfo = new PageInfo(sysUsers);
        for (SysUser sysUser : sysUsers) {
            UserRes dto = new UserRes();
            dto.setName(sysUser.getName());
            dto.setSid(sysUser.getSid());
            dto.setId(sysUser.getId().toString());
            SysUserStudentExample example1 = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = sysUserStudentMapper.selectByExample(example1).get(0);
            dto.setMonitor(sysUserStudent.getMonitor());
            dto.setSysClass(sysUserStudent.getSysClass());
            dto.setSysGrade(sysUserStudent.getSysGrade());
            res.add(dto);
        }

        PageInfo<UserRes> resPageInfo = new PageInfo<>(res);
        resPageInfo.setPageNum(pageInfo.getPageNum());
        resPageInfo.setPageSize(pageInfo.getPageSize());
        resPageInfo.setTotal(pageInfo.getTotal());
        resPageInfo.setPages(pageInfo.getPages());
        return resPageInfo;
    }

    @Override
    public PageInfo<RoleScoreRes> scoreList(int sysGrade, int projectId, PageRequestBean request) {

        List<RoleScoreRes> res = new ArrayList<>();
        PageInfo<RoleScoreRes> pageInfo = null;
        if (projectId > 0) {
            SysTestGradingModuleExample example = new SysTestGradingModuleExample();
            SysTestGradingModuleExample.Criteria criteria = example.createCriteria();
            criteria.andSysProjectIdEqualTo(projectId);
            PageHelper.startPage(request.getPageNum(), request.getPageSize(), true);
            List<SysTestGradingModule> sysTestGradingModules = sysTestGradingModuleMapper.selectByExample(example);
            pageInfo = new PageInfo(sysTestGradingModules);
            for (SysTestGradingModule sysTestGradingModule : sysTestGradingModules) {
                RoleScoreRes dto = new RoleScoreRes();
                dto.setAchievement(sysTestGradingModule.getAchievement());
                Integer studentId = sysTestGradingModule.getSysUserStudentId();
                SysUserStudent sysUserStudent = sysUserStudentMapper.selectByPrimaryKey(studentId.longValue());
                String sid = sysUserStudent.getSysUserSid();
                SysUserExample sysUserExample = new SysUserExample();
                SysUserExample.Criteria criteria1 = sysUserExample.createCriteria();
                criteria1.andSidEqualTo(sid);
                SysUser sysUser = sysUserMapper.selectByExample(sysUserExample).get(0);
                dto.setName(sysUser.getName());
                dto.setSysProjectId(projectId);
                res.add(dto);
            }
        }

        if (sysGrade > 0) {
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysGradeEqualTo(sysGrade);
            PageHelper.startPage(request.getPageNum(), request.getPageSize(), true);
            List<SysUserStudent> sysUserStudents = sysUserStudentMapper.selectByExample(example);
            pageInfo = new PageInfo(sysUserStudents);
            for (SysUserStudent sysUserStudent : sysUserStudents) {
                RoleScoreRes dto = new RoleScoreRes();
                SysTestGradingModuleExample example1 = new SysTestGradingModuleExample();
                SysTestGradingModuleExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andSysUserStudentIdEqualTo(sysUserStudent.getId().intValue());
                SysTestGradingModule sysTestGradingModule = sysTestGradingModuleMapper.selectByExample(example1).get(0);

                dto.setSysProjectId(sysTestGradingModule.getSysProjectId());
                dto.setAchievement(sysTestGradingModule.getAchievement());

                SysUserExample sysUserExample = new SysUserExample();
                SysUserExample.Criteria criteria2 = sysUserExample.createCriteria();
                criteria2.andSidEqualTo(sysUserStudent.getSysUserSid());
                SysUser sysUser = sysUserMapper.selectByExample(sysUserExample).get(0);
                dto.setName(sysUser.getName());
                res.add(dto);
            }
        }

        PageInfo<RoleScoreRes> resPageInfo = new PageInfo<>(res);
        resPageInfo.setPageNum(pageInfo.getPageNum());
        resPageInfo.setPageSize(pageInfo.getPageSize());
        resPageInfo.setTotal(pageInfo.getTotal());
        resPageInfo.setPages(pageInfo.getPages());
        return resPageInfo;
    }

    @Override
    public void modifyUserInfo(UserRequest request) {
        if (StringUtils.isNotBlank(request.getName()) && request.getId() > 0) {
            SysUser sysUser = new SysUser();
            sysUser.setName(request.getName());
            sysUser.setId(Long.valueOf(request.getId()));
            sysUserMapper.updateByPrimaryKeySelective(sysUser);
        }
        if (request.getId() > 0 && request.getMonitor() != null) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setMonitor(request.getMonitor());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }
        if (request.getId() > 0 && request.getMonitor() != null && request.getSysClass() > 0) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setMonitor(request.getMonitor());
            sysUserStudent.setSysClass(request.getSysClass());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (request.getId() > 0 && request.getMonitor() != null && request.getSysGrade() > 0) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setMonitor(request.getMonitor());
            sysUserStudent.setSysClass(request.getSysGrade());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (request.getId() > 0 && request.getMonitor() != null && request.getSysGrade() > 0 && request.getSysClass() > 0) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setMonitor(request.getMonitor());
            sysUserStudent.setSysClass(request.getSysGrade());
            sysUserStudent.setSysClass(request.getSysClass());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (request.getId() > 0 && request.getSysGrade() > 0 && request.getSysClass() > 0) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setSysClass(request.getSysGrade());
            sysUserStudent.setSysClass(request.getSysClass());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (request.getId() > 0 && request.getSysGrade() > 0) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setSysClass(request.getSysGrade());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (request.getId() > 0 && request.getSysClass() > 0) {
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setSysClass(request.getSysClass());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (StringUtils.isNotBlank(request.getName()) && request.getId() > 0 && request.getSysClass() > 0) {
            SysUser sysUser1 = new SysUser();
            sysUser1.setName(request.getName());
            sysUser1.setId(Long.valueOf(request.getId()));
            sysUserMapper.updateByPrimaryKeySelective(sysUser1);

            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setSysClass(request.getSysClass());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (StringUtils.isNotBlank(request.getName()) && request.getId() > 0 && request.getSysGrade() > 0) {
            SysUser sysUser1 = new SysUser();
            sysUser1.setName(request.getName());
            sysUser1.setId(Long.valueOf(request.getId()));
            sysUserMapper.updateByPrimaryKeySelective(sysUser1);

            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setSysClass(request.getSysGrade());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }

        if (StringUtils.isNotBlank(request.getName()) && request.getId() > 0 && request.getSysGrade() > 0 && request.getSysClass() > 0) {
            SysUser sysUser1 = new SysUser();
            sysUser1.setName(request.getName());
            sysUser1.setId(Long.valueOf(request.getId()));
            sysUserMapper.updateByPrimaryKeySelective(sysUser1);

            SysUser sysUser = sysUserMapper.selectByPrimaryKey(Long.valueOf(request.getId()));
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sysUser.getSid());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent.setSysClass(request.getSysGrade());
            sysUserStudent.setSysClass(request.getSysClass());
            sysUserStudentMapper.updateByExampleSelective(sysUserStudent, example);
        }
    }

    @Override
    public void delete(Long id) {
        sysUserMapper.deleteByPrimaryKey(id);
    }
}
