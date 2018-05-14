package com.example.test_physical_strength.service;

import com.example.test_physical_strength.constant.Errors;
import com.example.test_physical_strength.dto.PageRequestBean;
import com.example.test_physical_strength.dto.request.StrudentRScoreRequest;
import com.example.test_physical_strength.dto.response.StudentRScoreRes;
import com.example.test_physical_strength.dto.response.TestRes;
import com.example.test_physical_strength.exception.BusinessException;
import com.example.test_physical_strength.mapper.SysTestGradingModuleMapper;
import com.example.test_physical_strength.mapper.SysTestMapper;
import com.example.test_physical_strength.mapper.SysUserMapper;
import com.example.test_physical_strength.mapper.SysUserStudentMapper;
import com.example.test_physical_strength.model.SysTest;
import com.example.test_physical_strength.model.SysTestExample;
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
public class TeacherOperationServiceImpl implements TeacherOperationService {
    @Autowired
    private SysTestMapper sysTestMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysTestGradingModuleMapper sysTestGradingModuleMapper;

    @Autowired
    private SysUserStudentMapper sysUserStudentMapper;

    @Override
    public PageInfo<StudentRScoreRes> studentScoreList(PageRequestBean requestBean) {
        SysTestGradingModuleExample example = new SysTestGradingModuleExample();
        SysTestGradingModuleExample.Criteria criteria = example.createCriteria();
        List<StudentRScoreRes> res = new ArrayList<>();
        PageHelper.startPage(requestBean.getPageNum(), requestBean.getPageSize(), true);
        List<SysTestGradingModule> sysTests = sysTestGradingModuleMapper.selectByExample(example);
        PageInfo<StudentRScoreRes> resPageInfo = new PageInfo(sysTests);
        for (SysTestGradingModule sysTest : sysTests){
            StudentRScoreRes dto = new StudentRScoreRes();
            dto.setAdvice(sysTest.getAdvice());
            dto.setSysProjectId(sysTest.getSysProjectId());
            dto.setAchievement(sysTest.getAchievement());
            dto.setSysUserStudentId(sysTest.getSysUserStudentId());

            int ssid = sysTest.getSysUserStudentId();
            SysUserStudent sysUserStudent = sysUserStudentMapper.selectByPrimaryKey(Long.valueOf(ssid));
            String sid = sysUserStudent.getSysUserSid();
            SysUserExample sysUserExample = new SysUserExample();
            SysUserExample.Criteria criteria1 = sysUserExample.createCriteria();
            criteria1.andSidEqualTo(sid);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
            if (sysUsers.size() > 0){
                dto.setName(sysUsers.get(0).getName());
            }
            res.add(dto);
        }
        PageInfo<StudentRScoreRes> pageInfo = new PageInfo<>(res);
        pageInfo.setPages(resPageInfo.getPages());
        pageInfo.setTotal(resPageInfo.getTotal());
        pageInfo.setPageSize(resPageInfo.getPageSize());
        pageInfo.setPageNum(resPageInfo.getPageNum());
        return  pageInfo;
    }

    @Override
    public void modifyScore(Long sysUserStudentId, Long achievement) {
        if (sysUserStudentId > 0 && achievement > 0) {
            SysTestGradingModuleExample example = new SysTestGradingModuleExample();
            SysTestGradingModuleExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserStudentIdEqualTo(sysUserStudentId.intValue());
            SysTestGradingModule sysTestGradingModule = new SysTestGradingModule();
            sysTestGradingModule.setAchievement(achievement.intValue());
            sysTestGradingModuleMapper.updateByExampleSelective(sysTestGradingModule, example);
        }

    }

    @Override
    public void deleteScore(Long sysUserStudentId) {
        if (sysUserStudentId > 0) {
            SysTestGradingModuleExample example = new SysTestGradingModuleExample();
            SysTestGradingModuleExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserStudentIdEqualTo(sysUserStudentId.intValue());
            sysTestGradingModuleMapper.deleteByExample(example);
        }
    }

    @Override
    public void addScore(StrudentRScoreRequest request) {
        SysTestGradingModule sysTestGradingModule = new SysTestGradingModule();
        if (request.getAchievement() > 0) {
            sysTestGradingModule.setAchievement(request.getAchievement());
        }
        if (StringUtils.isNotBlank(request.getAdvice())) {
            sysTestGradingModule.setAdvice(request.getAdvice());
        }
        if (request.getSid() > 0) {
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(request.getSid().toString());
            SysUserStudent sysUserStudent = new SysUserStudent();
            sysUserStudent = sysUserStudentMapper.selectByExample(example).get(0);
            sysTestGradingModule.setSysUserStudentId(sysUserStudent.getId().intValue());
        }
        if (request.getSysProjectId() > 0){
            sysTestGradingModule.setSysProjectId(request.getSysProjectId());
        }
        sysTestGradingModuleMapper.insertSelective(sysTestGradingModule);
    }

    @Override
    public PageInfo<StudentRScoreRes> studentScoreList(Long sysClass, PageRequestBean requestBean) {
        if (sysClass <= 0){
            throw  new BusinessException(Errors.SYSTEM_DATA_NOT_FOUND);
        }
        SysTestGradingModuleExample example = new SysTestGradingModuleExample();
        SysTestGradingModuleExample.Criteria criteria = example.createCriteria();
        List<StudentRScoreRes> res = new ArrayList<>();
        PageHelper.startPage(requestBean.getPageNum(), requestBean.getPageSize(), true);
        List<SysTestGradingModule> sysTests = sysTestGradingModuleMapper.selectByExample(example);
        PageInfo<StudentRScoreRes> resPageInfo = new PageInfo(sysTests);
        for (SysTestGradingModule sysTest : sysTests){
            int ssid = sysTest.getSysUserStudentId();
            SysUserStudent sysUserStudent = sysUserStudentMapper.selectByPrimaryKey(Long.valueOf(ssid));
            String sid = sysUserStudent.getSysUserSid();
            Integer sysClass1 = sysUserStudent.getSysClass();
            if (sysClass.intValue() == sysClass1){
                StudentRScoreRes dto = new StudentRScoreRes();
                dto.setAdvice(sysTest.getAdvice());
                dto.setSysProjectId(sysTest.getSysProjectId());
                dto.setAchievement(sysTest.getAchievement());
                dto.setSysUserStudentId(sysTest.getSysUserStudentId());

                SysUserExample sysUserExample = new SysUserExample();
                SysUserExample.Criteria criteria1 = sysUserExample.createCriteria();
                criteria1.andSidEqualTo(sid);
                List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
                if (sysUsers.size() > 0){
                    dto.setName(sysUsers.get(0).getName());
                }
                res.add(dto);
            }
        }
        PageInfo<StudentRScoreRes> pageInfo = new PageInfo<>(res);
        pageInfo.setPages(resPageInfo.getPages());
        pageInfo.setTotal(resPageInfo.getTotal());
        pageInfo.setPageSize(resPageInfo.getPageSize());
        pageInfo.setPageNum(resPageInfo.getPageNum());
        return  pageInfo;
    }

    @Override
    public PageInfo<TestRes> studentTestList(PageRequestBean requestBean) {

        SysTestExample example = new SysTestExample();
        SysTestExample.Criteria criteria = example.createCriteria();
        List<TestRes> res = new ArrayList<>();
        PageHelper.startPage(requestBean.getPageNum(), requestBean.getPageSize(), true);
        List<SysTest> sysTests = sysTestMapper.selectByExample(example);
        PageInfo<TestRes> resPageInfo = new PageInfo(sysTests);
        for (SysTest sysTest : sysTests){
            TestRes dto = new TestRes();
            dto.setAdvice(sysTest.getAdvice());
            dto.setId(sysTest.getId().intValue());
            dto.setStatus(sysTest.getStatus());
            dto.setStudentNum(sysTest.getStudentNum());
            dto.setSysClass(sysTest.getSysClass());
            dto.setTypeStatus(sysTest.getStatus());
            dto.setType(sysTest.getType());
            dto.setSysProjectId(sysTest.getSysProjectId());
            res.add(dto);
        }
        PageInfo<TestRes> pageInfo = new PageInfo<>(res);
        pageInfo.setPages(resPageInfo.getPages());
        pageInfo.setTotal(resPageInfo.getTotal());
        pageInfo.setPageSize(resPageInfo.getPageSize());
        pageInfo.setPageNum(resPageInfo.getPageNum());
        return  pageInfo;
    }

    @Override
    public void checkStatus(Long id, Short status) {
        if (id>0&& status > 0){
            SysTest sysTest = new SysTest();
            sysTest.setId(id);
            sysTest.setStatus(status);
            sysTestMapper.updateByPrimaryKeySelective(sysTest);
        }
    }
}
