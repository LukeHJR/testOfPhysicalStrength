package com.example.test_physical_strength.service;

import com.example.test_physical_strength.constant.Errors;
import com.example.test_physical_strength.dto.request.MakeUpExamRequest;
import com.example.test_physical_strength.dto.request.SlowMeasuringOrExemptingRequest;
import com.example.test_physical_strength.dto.request.TestReservationRequest;
import com.example.test_physical_strength.dto.response.StudentScoreRes;
import com.example.test_physical_strength.exception.BusinessException;
import com.example.test_physical_strength.mapper.SysTestGradingModuleMapper;
import com.example.test_physical_strength.mapper.SysTestMapper;
import com.example.test_physical_strength.mapper.SysUserMapper;
import com.example.test_physical_strength.mapper.SysUserStudentMapper;
import com.example.test_physical_strength.model.SysTest;

import com.example.test_physical_strength.model.SysTestGradingModule;
import com.example.test_physical_strength.model.SysTestGradingModuleExample;
import com.example.test_physical_strength.model.SysUser;
import com.example.test_physical_strength.model.SysUserStudent;
import com.example.test_physical_strength.model.SysUserStudentExample;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * @title
 * @Author huangjiarui
 * @date: 2018-05-14
 */
@Service
public class TestOpreationServiceImpl implements TestOpreationService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserStudentMapper sysUserStudentMapper;

    @Autowired
    private SysTestGradingModuleMapper sysTestGradingModuleMapper;

    @Autowired
    private SysTestMapper sysTestMapper;


    @Override
    public List<StudentScoreRes> searchScore(Long id) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        String sid = sysUser.getSid();
        SysUserStudentExample example = new SysUserStudentExample();
        SysUserStudentExample.Criteria criteria = example.createCriteria();
        criteria.andSysUserSidEqualTo(sid);
        SysUserStudent sysUserStudent = sysUserStudentMapper.selectByExample(example).get(0);
        Long studentId = sysUserStudent.getId();

        SysTestGradingModuleExample example1 = new SysTestGradingModuleExample();
        SysTestGradingModuleExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andSysUserStudentIdEqualTo(studentId.intValue());
        List<StudentScoreRes> res = new ArrayList<>();
        List<SysTestGradingModule> sysTestGradingModules = sysTestGradingModuleMapper.selectByExample(example1);
        for (SysTestGradingModule sysTestGradingModule : sysTestGradingModules) {
            StudentScoreRes dto = new StudentScoreRes();
            dto.setAchievement(sysTestGradingModule.getAchievement());
            dto.setAdvice(sysTestGradingModule.getAdvice());
            dto.setName(sysUser.getName());
            dto.setSysProjectId(sysTestGradingModule.getSysProjectId());
            res.add(dto);
        }

        return res;
    }

    @Override
    public void slowMeasuringOrExempting(SlowMeasuringOrExemptingRequest request) {

        if (request.getSid() > 0 && request.getSysProjectId() > 0 && request.getType() > 0
                && StringUtils.isNotBlank(request.getReason())
                && request.getSysClass() > 0
                && StringUtils.isNotBlank(request.getName())) {
            SysTest sysTest = new SysTest();
            sysTest.setReason(request.getReason());
            sysTest.setType(request.getType());
            sysTest.setSysClass(request.getSysClass());
            sysTest.setSysProjectId(request.getSysProjectId());
            sysTest.setStudentNum(String.valueOf(1));
            sysTest.setAdvice(new Date().toString());
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(request.getSid().toString());
            SysUserStudent sysUserStudent = sysUserStudentMapper.selectByExample(example).get(0);
            sysTest.setSysUserStudentId(sysUserStudent.getId().intValue());
            sysTestMapper.insertSelective(sysTest);

        }
    }

    @Override
    public void makeUpExam(MakeUpExamRequest request) {


        if (request.getSid() > 0 && request.getSysProjectId() > 0 && request.getType() > 0
                && StringUtils.isNotBlank(request.getAdvice())
                && request.getSysClass() > 0
                && StringUtils.isNotBlank(request.getName())) {
            SysTest sysTest = new SysTest();
            sysTest.setType(request.getType());
            sysTest.setSysClass(request.getSysClass());
            sysTest.setSysProjectId(request.getSysProjectId());
            sysTest.setStudentNum(String.valueOf(1));
            sysTest.setAdvice(new Date().toString());
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(request.getSid().toString());
            SysUserStudent sysUserStudent = sysUserStudentMapper.selectByExample(example).get(0);
            sysTest.setSysUserStudentId(sysUserStudent.getId().intValue());
            sysTestMapper.insertSelective(sysTest);
        }
    }

    @Override
    public void testReservation(TestReservationRequest request, String sid) {
        if (request.getStatus() == 1) {//班级
            SysUserStudentExample example = new SysUserStudentExample();
            SysUserStudentExample.Criteria criteria = example.createCriteria();
            criteria.andSysUserSidEqualTo(sid);
            SysUserStudent sysUserStudent = sysUserStudentMapper.selectByExample(example).get(0);
            Integer monitor = sysUserStudent.getMonitor();
            if (monitor == 0) {
                throw new BusinessException(Errors.SYSTEM_NO_ACCESS, "必须是班长才能预约班级体测！");
            }
            if (request.getSid() > 0 && request.getSysProjectId() > 0 && request.getType() > 0
                    && StringUtils.isNotBlank(request.getAdvice())
                    && request.getSysClass() > 0
                    && StringUtils.isNotBlank(request.getStudentNum())
                    && StringUtils.isNotBlank(request.getName())) {
                SysTest sysTest = new SysTest();
                sysTest.setType(request.getType());
                sysTest.setSysClass(request.getSysClass());
                sysTest.setSysProjectId(request.getSysProjectId());
                sysTest.setStudentNum(request.getStudentNum());
                sysTest.setAdvice(request.getAdvice());
                SysUserStudentExample example1 = new SysUserStudentExample();
                SysUserStudentExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andSysUserSidEqualTo(request.getSid().toString());
                SysUserStudent sysUserStudent1 = sysUserStudentMapper.selectByExample(example1).get(0);
                sysTest.setSysUserStudentId(sysUserStudent1.getId().intValue());
                sysTestMapper.insertSelective(sysTest);
            }
        }
        if (request.getStatus() == 2) {//个人
            if (request.getSid() > 0 && request.getSysProjectId() > 0 && request.getType() > 0
                    && StringUtils.isNotBlank(request.getAdvice())
                    && request.getSysClass() > 0
                    && StringUtils.isNotBlank(request.getName())) {
                SysTest sysTest = new SysTest();
                sysTest.setType(request.getType());
                sysTest.setSysClass(request.getSysClass());
                sysTest.setSysProjectId(request.getSysProjectId());
                sysTest.setStudentNum(String.valueOf(1));
                sysTest.setAdvice(new Date().toString());
                SysUserStudentExample example = new SysUserStudentExample();
                SysUserStudentExample.Criteria criteria = example.createCriteria();
                criteria.andSysUserSidEqualTo(request.getSid().toString());
                SysUserStudent sysUserStudent = sysUserStudentMapper.selectByExample(example).get(0);
                sysTest.setSysUserStudentId(sysUserStudent.getId().intValue());
                sysTestMapper.insertSelective(sysTest);
            }
        }
    }
}
